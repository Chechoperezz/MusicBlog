package com.example.MusicBlog.CONTROLLERS;

import com.example.MusicBlog.DTO.MemoryDTO;
import com.example.MusicBlog.DTO.SongsDTO;
import com.example.MusicBlog.MODELS.UserEntity;
import com.example.MusicBlog.SERVICE.MemoryService;
import com.example.MusicBlog.SERVICE.SongService;
import com.example.MusicBlog.SERVICE.UserEntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class MemoryController {

    private final MemoryService memoryService;
    private final SongService songService;
    private final UserEntityService userEntityService;

    @Autowired
    public MemoryController(MemoryService memoryService, SongService songService, UserEntityService userEntityService) {
        this.memoryService = memoryService;
        this.songService = songService;
        this.userEntityService = userEntityService;
    }

    @GetMapping("/memory/new")
    public String showMemoryForm(@RequestParam("songId") Long songId, Model model) {
        SongsDTO songsDTO = songService.findSongById(songId);
        MemoryDTO memoryDTO = new MemoryDTO();
        memoryDTO.setSongId(songsDTO.getId());
        model.addAttribute("memory", memoryDTO);
        return "new-memory";
    }

    @PostMapping("/memory/save")
    public String saveMemory(@Valid @ModelAttribute("memory") MemoryDTO memoryDTO, BindingResult bindingResult,
                             Principal principal) {

        if (bindingResult.hasErrors()) {
            return "new-memory";
        }

        UserEntity user = userEntityService.findByUserName(principal.getName());
        memoryDTO.setUserId(user.getId());
        memoryService.saveMemory(memoryDTO);
        return "redirect:/songs/" + memoryDTO.getSongId();
    }

    @GetMapping("/memory/{memoryId}/edit")
    public String showEditForm(@PathVariable("memoryId") Long memoryId, Model model) {
        MemoryDTO memoryDTO = memoryService.findMemoryById(memoryId);
        model.addAttribute("memory", memoryDTO);
        return "edit-memory";
    }

    @PostMapping("/memory/{memoryId}/edit")
    public String editMemory(@PathVariable("memoryId") Long memoryId, @Valid @ModelAttribute("memory") MemoryDTO memoryDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-memory";
        }
        memoryDTO.setId(memoryId);
        memoryService.updateMemory(memoryDTO);
        return "redirect:/songs/" + memoryDTO.getSongId();
    }

    @GetMapping("/memory/{memoryId}/delete")
    public String deleteMemory(@PathVariable("memoryId") Long memoryId) {
        memoryService.deleteMemory(memoryId);
        return "redirect:/songs";
    }
}
