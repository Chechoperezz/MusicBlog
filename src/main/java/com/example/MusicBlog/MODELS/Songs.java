package com.example.MusicBlog.MODELS;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "songs")
public class Songs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String artist;
    private String album;
    private String genre;
    private String releaseDate;
    private Integer duration;
    private String reproductionUrl;

}
