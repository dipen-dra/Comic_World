package com.example.comixnookbackend;

import com.example.comixnookbackend.Entity.Genre;
import com.example.comixnookbackend.Repo.GenreRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GenreRepositoryTest {
    @Autowired
    private GenreRepo genreRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveGenre(){
        Genre genre = new Genre();

        genre.setGenre("Marvel Comics");

        genre = genreRepo.save(genre);

        Assertions.assertThat(genre.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void findById(){
        Genre genre = genreRepo.findById(1L).get();

        Assertions.assertThat(genre.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void findAll(){
        List<Genre> genreList = genreRepo.findAll();

        Assertions.assertThat(genreList.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updateGenre(){
        Genre genre = genreRepo.findById(1L).get();

        genre.setGenre("DC Comics");

        genre = genreRepo.save(genre);

        Assertions.assertThat(genre.getGenre()).isEqualTo("DC Comics");
    }

    @Test
    @Order(5)
    public void deleteById(){
        genreRepo.deleteById(1L);

        Genre genre1 = null;
        Optional<Genre> genre = genreRepo.findById(1L);

        if(genre.isPresent()){
            genre1 = genre.get();
        }

        Assertions.assertThat(genre1).isNull();
    }
}
