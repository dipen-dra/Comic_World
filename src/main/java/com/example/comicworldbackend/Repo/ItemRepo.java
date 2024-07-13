package com.example.comicworldbackend.Repo;

import com.example.comicworldbackend.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item,Long> {
}
