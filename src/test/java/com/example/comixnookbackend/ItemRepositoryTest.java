package com.example.comixnookbackend;

import com.example.comixnookbackend.Entity.Genre;
import com.example.comixnookbackend.Entity.Item;
import com.example.comixnookbackend.Repo.GenreRepo;
import com.example.comixnookbackend.Repo.ItemRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemRepositoryTest {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private GenreRepo genreRepo;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveItem(){

        Genre genre = new Genre();
        genre.setGenre("Mervel Test");

        genre = genreRepo.save(genre);
        Assertions.assertThat(genre.getId()).isGreaterThan(0);

        Item item = new Item();
        item.setItemName("Item Name1");
        item.setReleasedDate(LocalDate.now());
        item.setItemDescription("This is the discription of the comic");
        item.setDownloadLink("https://example.com/download");
        item.setGenreId(genre);

        item = itemRepo.save(item);

        Assertions.assertThat(item.getItemId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getById() {

        Item item = itemRepo.findById(1L).get();
        Assertions.assertThat(item.getItemId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void getAllData() {
        List<Item> productList = itemRepo.findAll();
        Assertions.assertThat(productList.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updateProduct() {
        Item item = itemRepo.findById(1L).orElse(null);
        Assertions.assertThat(item).isNotNull();

        Genre genre = genreRepo.findById(1L).orElse(null);
        Assertions.assertThat(genre).isNotNull();

        item.setItemDescription("Updated Description");
        item.setGenreId(genre);

        item = itemRepo.save(item);

        Assertions.assertThat(item.getItemDescription()).isEqualTo("Updated description");
    }

    @Test
    @Order(5)
    public void deleteById() {
        itemRepo.deleteById(1L);
        Optional<Item> item = itemRepo.findById(1L);
        Assertions.assertThat(item).isEmpty();
    }
}
