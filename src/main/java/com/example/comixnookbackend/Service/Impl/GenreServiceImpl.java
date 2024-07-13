package com.example.comixnookbackend.Service.Impl;

import com.example.comixnookbackend.Entity.Genre;
import com.example.comixnookbackend.Pojo.GenrePojo;
import com.example.comixnookbackend.Repo.GenreRepo;
import com.example.comixnookbackend.Service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepo genreRepo;

    @Override
    public void save(GenrePojo genrePojo) {
        Genre genre = new Genre();

        if(genrePojo.getId()!=null){
            genre=genreRepo.findById(genrePojo.getId()).get();
        }

        genre.setGenre(genrePojo.getGenre());
        genreRepo.save(genre);
    }


    @Override
    public List<Genre> getAll() {
        return genreRepo.findAll(); // select * from genre
    }

    @Override
    public void deleteById(Long id) {
        genreRepo.deleteById(id); // delete from genre where id =?1
    }

    @Override
    public Optional<Genre> getById(Long id) {
        return genreRepo.findById(id);
    }

}
