package com.example.comixnookbackend.Controller;

import com.example.comixnookbackend.Entity.Genre;
import com.example.comixnookbackend.Pojo.GenrePojo;
import com.example.comixnookbackend.Service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping("genre")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PostMapping("/save")
    public String saveUser(@RequestBody GenrePojo genrePojo){
        genreService.save(genrePojo);
        return "in this section";
    }

    @GetMapping("/getAll")
    public List<Genre> getAll(){
        return this.genreService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Genre> getById(@PathVariable("id") Long id){
        return this.genreService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        this.genreService.deleteById(id);
    }

}
