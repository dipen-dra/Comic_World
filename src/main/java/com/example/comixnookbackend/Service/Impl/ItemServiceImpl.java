package com.example.comixnookbackend.Service.Impl;

import com.example.comixnookbackend.Entity.Genre;
import com.example.comixnookbackend.Entity.Item;
import com.example.comixnookbackend.Pojo.ItemPojo;
import com.example.comixnookbackend.Repo.GenreRepo;
import com.example.comixnookbackend.Repo.ItemRepo;
import com.example.comixnookbackend.Service.ItemService;

import com.example.comixnookbackend.util.ImageToBase64;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;
    private final GenreRepo genreRepo;

    private final String UPLOAD_DIRECTORY = new StringBuilder().append(System.getProperty("user.dir")).append("/Comix-Images/item-images").toString();
    ImageToBase64 imageToBase64 = new ImageToBase64();

    @Override
    public void saveItem(ItemPojo itemPojo) throws IOException {
        Item item;
        if (itemPojo.getItemId() != null) {
            item = itemRepo.findById(itemPojo.getItemId())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found with ID: " + itemPojo.getItemId()));
        } else {
            item = new Item();
        }

        item.setItemName(itemPojo.getItemName());
        item.setReleasedDate(itemPojo.getReleasedDate());
        item.setItemDescription(itemPojo.getItemDescription());
        item.setDownloadLink(itemPojo.getDownloadLink());

        if (itemPojo.getItemImage() != null) {
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, itemPojo.getItemImage().getOriginalFilename());
            Files.write(fileNameAndPath, itemPojo.getItemImage().getBytes());
        }
        item.setItemImage(itemPojo.getItemImage().getOriginalFilename());

        Genre genre = genreRepo.findById(itemPojo.getGenreId())
                .orElseThrow(() -> new EntityNotFoundException("Genre not found with ID: " + itemPojo.getGenreId()));
        item.setGenreId(genre);

        itemRepo.save(item);
    }

    @Override
    public List<Item> getAll(){
        List<Item> items = itemRepo.findAll();
        items = items.stream().map(item -> {
            item.setItemImage(imageToBase64.getImageBase64("/item-images/" + item.getItemImage()));
            return item;
        }).collect(Collectors.toList());
        return items;
    }

//    @Override
//    public List<Item> getAll(){
//        return itemRepo.findAll();
//    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemRepo.findById(id);
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepo.deleteById(id);
    }
}
