package com.example.MusicBlog.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemoryDTO {


    @NotEmpty
    private Long id;
    @NotEmpty
    private String content;
    @NotEmpty
    private Long userId;
    @NotEmpty
    private Long songId;

    @NotEmpty
    private LocalDateTime createdAt;
}
