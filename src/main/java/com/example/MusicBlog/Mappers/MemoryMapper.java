package com.example.MusicBlog.Mappers;

import com.example.MusicBlog.DTO.MemoryDTO;
import com.example.MusicBlog.MODELS.Memory;
import com.example.MusicBlog.MODELS.Songs;
import com.example.MusicBlog.MODELS.UserEntity;
import java.time.LocalDateTime;


public class MemoryMapper {

    public static Memory mapMemoryDTOToMemory(MemoryDTO memoryDTO) {
        Memory memory=  Memory.builder()
                .id(memoryDTO.getId())
                .user(UserEntity.builder().id(memoryDTO.getUserId()).build())
                .song(Songs.builder().id(memoryDTO.getSongId()).build())
                .content(memoryDTO.getContent())
                .createdAt(LocalDateTime.now())
                .build();
        return memory;
    }

    public static MemoryDTO mapMemoryToMemoryDTO(Memory memory) {
        MemoryDTO memoryDTO= MemoryDTO.builder()
                .id(memory.getId())
                .userId(memory.getUser().getId())
                .songId(memory.getSong().getId())
                .content(memory.getContent())
                .build();
        return memoryDTO;
    }
}
