package com.example.MusicBlog.SERVICE;

import com.example.MusicBlog.DTO.SongsDTO;
import com.example.MusicBlog.MODELS.Songs;

import java.util.List;

public interface SongService {

    void saveSong(SongsDTO songsDTO);

    List<SongsDTO> searchByTitleOrArtist(String query);

    void delete(Long songId);

    SongsDTO findSongById(Long songId);

    void updateSong(SongsDTO songsDTO);

    Songs existByTitleAndArtist(String title, String artist);
}
