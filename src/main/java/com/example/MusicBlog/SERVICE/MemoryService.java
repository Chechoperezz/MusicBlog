package com.example.MusicBlog.SERVICE;

import com.example.MusicBlog.DTO.MemoryDTO;
import com.example.MusicBlog.MODELS.Memory;
import com.example.MusicBlog.MODELS.Songs;
import com.example.MusicBlog.MODELS.Users;

import java.util.List;

public interface MemoryService {
    void saveMemory(MemoryDTO memoryDTO);
    List<Memory> findBySong(Songs song);
    List<Memory> findByUser(Users user);
    MemoryDTO findMemoryById(Long memoryId);
    void updateMemory(MemoryDTO memoryDTO);
    void deleteMemory(Long memoryId);
}
