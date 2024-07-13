package com.example.comixnookbackend.Pojo;

import jakarta.validation.constraints.NotEmpty;
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
