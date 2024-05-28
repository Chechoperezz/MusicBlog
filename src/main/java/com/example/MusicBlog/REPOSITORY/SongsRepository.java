package com.example.MusicBlog.REPOSITORY;

import com.example.MusicBlog.MODELS.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongsRepository extends JpaRepository<Songs, Long> {

    Songs findSongsById(Long id);

    Songs findByTitleAndArtist(String title, String artist);

    List<Songs> findByTitleContainingIgnoreCase(String title);

    @Query(value = "SELECT * FROM songs WHERE title || ' ' || artist ILIKE %:query%", nativeQuery = true)
    List<Songs> searchByTitleOrArtist(@Param("query") String query);

    List<Songs> findByArtistContainingIgnoreCase(String artist);
}

