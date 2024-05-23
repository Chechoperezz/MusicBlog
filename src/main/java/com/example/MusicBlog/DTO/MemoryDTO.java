package com.example.MusicBlog.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemoryDTO {


    @NotEmpty
    private String content;
    @NotEmpty
    private Long id;
    @NotEmpty
    private Long userId;
    @NotEmpty
    private Long songId;
}
