package com.example.MusicBlog.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SongsDTO {

    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String artist;
    private String album;
    private String genre;
    @NotEmpty
    private String releaseDate;
    @NotEmpty
    private Integer duration;
    @NotEmpty
    private String reproductionUrl;
}
