package com.example.MusicBlog.CONTROLLERS;

import com.example.MusicBlog.DTO.SongsDTO;
import com.example.MusicBlog.MODELS.Songs;
import com.example.MusicBlog.SERVICE.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SongsController {

    @Autowired
    private SongService songService;

    @GetMapping("/publicate")
    public String showPublicationForm(Model model) {
        model.addAttribute("song", new SongsDTO());
        return "publicate-song";
    }

    @PostMapping("/song/publicate")
    public String processPublicationForm(@Valid @ModelAttribute("song") SongsDTO songsDTO, Model model,
                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "publicate-song";
        }

        Songs existingSong = songService.existByTitleAndArtist(songsDTO.getTitle(), songsDTO.getArtist());
        if (existingSong != null) {
            return "redirect:/publicate?fail";
        }

        songService.saveSong(songsDTO);
        return "redirect:/home";
    }

    @GetMapping("/songs/search")
    public String searchSongs(@RequestParam("query") String query, Model model) {
        List<SongsDTO> songs = songService.searchByTitleOrArtist(query);
        model.addAttribute("songs", songs);
        model.addAttribute("query", query);
        return "search-song";
    }

    @GetMapping("/songs/searchAjax")
    @ResponseBody
    public List<SongsDTO> searchSongsAJAX(@RequestParam("query") String query) {
        return songService.searchByTitleOrArtist(query);
    }

    @GetMapping("/songs/{songId}/delete")
    public String deleteSong(@PathVariable("songId") Long songId) {
        songService.delete(songId);
        return "redirect:/home";
    }

    @GetMapping("/songs/{songId}/edit")
    public String showEditForm(@PathVariable("songId") Long songId, Model model) {
        SongsDTO songsDTO = songService.findSongById(songId);
        model.addAttribute("song", songsDTO);
        return "edit-song";
    }

    @PostMapping("/songs/{songId}/edit")
    public String editSong(@PathVariable("songId") Long songId, @Valid @ModelAttribute("song") SongsDTO songsDTO,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-song";
        }

        songsDTO.setId(songId);
        songService.updateSong(songsDTO);
        return "redirect:/home";
    }
}

