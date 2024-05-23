package com.example.MusicBlog.SERVICE;

import com.example.MusicBlog.DTO.SongsDTO;
import com.example.MusicBlog.MODELS.Songs;

import java.util.List;

public interface SongService {

    void saveSong(SongsDTO songsDTO);

    Songs existByArtist(String artist);

    Songs existByTitle(String title);

    Songs existByTitleAndArtist(String title,String artist);

    List<Songs> searchByTitleOrArtist(String query);

    List<Songs> searchByArtist(String artist);

    List<Songs> searchByTitle(String title);

    void delete(Long songId);

    SongsDTO findSongById(Long songId);

    void updateSong(SongsDTO songsDTO);
}
