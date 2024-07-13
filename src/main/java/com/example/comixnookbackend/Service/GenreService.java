package com.example.comixnookbackend.Service;

import com.example.comixnookbackend.Entity.Genre;
import com.example.comixnookbackend.Pojo.GenrePojo;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    void save(GenrePojo genrePojo);

    List<Genre> getAll();

    Optional<Genre> getById(Long id);

    void deleteById(Long id);
}
