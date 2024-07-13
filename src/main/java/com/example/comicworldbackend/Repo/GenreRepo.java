package com.example.comicworldbackend.Repo;

import com.example.comicworldbackend.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepo extends JpaRepository<Genre,Long> {

}
