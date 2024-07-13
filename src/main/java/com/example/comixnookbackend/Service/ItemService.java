package com.example.comixnookbackend.Service;

import com.example.comixnookbackend.Entity.Item;
import com.example.comixnookbackend.Pojo.ItemPojo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ItemService {

    void saveItem(ItemPojo itemPojo) throws IOException;

    List<Item> getAll();

    Optional<Item> getItemById(Long id);

    void deleteItemById(Long id);
}
