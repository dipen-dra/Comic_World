package com.example.comicworldbackend.Service;

import com.example.comicworldbackend.Entity.Genre;
import com.example.comicworldbackend.Pojo.GenrePojo;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    void save(GenrePojo genrePojo);

    List<Genre> getAll();

    Optional<Genre> getById(Long id);

    void deleteById(Long id);
}
