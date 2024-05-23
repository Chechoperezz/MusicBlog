package com.example.MusicBlog.REPOSITORY;

import com.example.MusicBlog.MODELS.Memory;
import com.example.MusicBlog.MODELS.Songs;
import com.example.MusicBlog.MODELS.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, Long> {
    List<Memory> findBySong(Songs song);
    List<Memory> findByUser(Users user);
}
