package com.example.comicworldbackend.Service;

import com.example.comicworldbackend.Entity.Item;
import com.example.comicworldbackend.Pojo.ItemPojo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ItemService {

    void saveItem(ItemPojo itemPojo) throws IOException;

    List<Item> getAll();

    Optional<Item> getItemById(Long id);

    void deleteItemById(Long id);
}
