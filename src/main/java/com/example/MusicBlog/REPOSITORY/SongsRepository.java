package com.example.MusicBlog.REPOSITORY;

import com.example.MusicBlog.MODELS.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongsRepository extends JpaRepository<Songs, Long> {

    Songs findSongsById(Long id);

    Songs findByArtist (String artist);

    Songs findByTitle(String title);

    Songs findByTitleAndArtist(String title, String artist);

    List<Songs> findByTitleContainingIgnoreCase(String title);
    List<Songs> findByArtistContainingIgnoreCase(String artist);
    List<Songs> findByTitleContainingIgnoreCaseOrArtistContainingIgnoreCase(String title, String artist);
}

