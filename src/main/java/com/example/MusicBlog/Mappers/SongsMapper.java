package com.example.MusicBlog.Mappers;

import com.example.MusicBlog.DTO.SongsDTO;
import com.example.MusicBlog.MODELS.Songs;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SongsMapper {

    public static Songs mapSongDTOToSong(SongsDTO songsDTO) {
        return Songs.builder()
                .id(songsDTO.getId())
                .title(songsDTO.getTitle())
                .artist(songsDTO.getArtist())
                .album(songsDTO.getAlbum())
                .genre(songsDTO.getGenre())
                .releaseDate(songsDTO.getReleaseDate())
                .duration(songsDTO.getDuration())
                .reproductionUrl(songsDTO.getReproductionUrl())
                .build();
    }

    public static SongsDTO mapSongToSongDTO(Songs songs) {
        return SongsDTO.builder()
                .id(songs.getId())
                .title(songs.getTitle())
                .artist(songs.getArtist())
                .album(songs.getAlbum())
                .genre(songs.getGenre())
                .releaseDate(songs.getReleaseDate())
                .duration(songs.getDuration())
                .reproductionUrl(songs.getReproductionUrl())
                .build();
    }
}

