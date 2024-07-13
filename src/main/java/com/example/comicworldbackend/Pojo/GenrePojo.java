package com.example.comicworldbackend.Pojo;

import lombok.*;
import jakarta.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenrePojo {

    private Long id;

    @NotNull
    private String genre;
}
