package com.example.MusicBlog.SERVICE.impl;

import com.example.MusicBlog.DTO.SongsDTO;
import com.example.MusicBlog.MODELS.Songs;
import com.example.MusicBlog.Mappers.SongsMapper;
import com.example.MusicBlog.REPOSITORY.SongsRepository;
import com.example.MusicBlog.SERVICE.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private SongsRepository songsRepository;
    private SongsMapper songsMapper;
    public void saveSong(SongsDTO songsDTO){
        Songs songs = SongsMapper.mapSongDTOToSong(songsDTO);
        songsRepository.save(songs);
    }

    @Override
    public Songs existByArtist(String artist) {
        Songs songs = songsRepository.findByArtist(artist);
        return songs;
    }

    @Override
    public Songs existByTitle(String title) {
        Songs songs = songsRepository.findByTitle(title);
        return songs;
    }

    @Override
    public Songs existByTitleAndArtist(String title, String artist) {
        return null;
    }

    public List<Songs> searchByTitle(String title) {
        return songsRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public void delete(Long songId) {
        songsRepository.deleteById(songId);

    }

    @Override
    public SongsDTO findSongById(Long songId) {
         Songs songs = songsRepository.findSongsById(songId);
         return SongsMapper.mapSongToSongDTO(songs);

    }

    @Override
    public void updateSong(SongsDTO songsDTO) {
        Songs songs = SongsMapper.mapSongDTOToSong(songsDTO);
        songsRepository.save(songs);
    }

    public List<Songs> searchByArtist(String artist) {
        return songsRepository.findByArtistContainingIgnoreCase(artist);
    }

    public List<Songs> searchByTitleOrArtist(String query) {
        return songsRepository.findByTitleContainingIgnoreCaseOrArtistContainingIgnoreCase(query, query);
    }

}
