package com.example.MusicBlog.SERVICE.impl;

import com.example.MusicBlog.DTO.MemoryDTO;
import com.example.MusicBlog.MODELS.Memory;
import com.example.MusicBlog.MODELS.Songs;
import com.example.MusicBlog.MODELS.Users;
import com.example.MusicBlog.Mappers.MemoryMapper;
import com.example.MusicBlog.REPOSITORY.MemoryRepository;
import com.example.MusicBlog.REPOSITORY.SongsRepository;
import com.example.MusicBlog.REPOSITORY.UserEntityRepository;
import com.example.MusicBlog.SERVICE.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryServiceImpl implements MemoryService {

    @Autowired
    private MemoryRepository memoryRepository;
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private SongsRepository songsRepository;


    @Override
    public void saveMemory(MemoryDTO memoryDTO) {
        Memory memory = MemoryMapper.mapMemoryDTOToMemory(memoryDTO);
        memoryRepository.save(memory);
    }

    @Override
    public List<Memory> findBySong(Songs song) {
        return memoryRepository.findBySong(song);
    }

    @Override
    public List<Memory> findByUser(Users user) {
        return memoryRepository.findByUser(user);
    }

    @Override
    public MemoryDTO findMemoryById(Long memoryId) {
        Memory memory = memoryRepository.findById(memoryId).orElse(null);
        return MemoryMapper.mapMemoryToMemoryDTO(memory);
    }

    @Override
    public void deleteMemory(Long memoryId) {
        memoryRepository.deleteById(memoryId);
    }

    @Override
    public void updateMemory(MemoryDTO memoryDTO) {
        Memory memory = MemoryMapper.mapMemoryDTOToMemory(memoryDTO);
        memoryRepository.save(memory);
    }
}
