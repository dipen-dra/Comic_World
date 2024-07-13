package com.example.comicworldbackend.Controller;

import com.example.comicworldbackend.Entity.User;
import com.example.comicworldbackend.Pojo.NewPasswordPojo;
import com.example.comicworldbackend.Pojo.UserPojo;
import com.example.comicworldbackend.Service.UserService;
import com.example.comicworldbackend.helper.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin("*")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ApiResponse apiResponse;

    @PostMapping("/save")
    public String saveUser(@Valid @RequestBody UserPojo userPojo){
        userService.save(userPojo);
        return "data created successfully";
    }

    @GetMapping("/getAll")
    public List<User> getAll(){

        return this.userService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<User> getById(@PathVariable("id") Long id){

        return this.userService.getById(id);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        this.userService.deleteById(id);
    }

    @GetMapping("/getByEmail/{email}")
    public Optional<User> getByEmail(@PathVariable("email") String email) {
        return this.userService.getByEmail(email);
    }

    @PostMapping("/new-password")
    public String setNewPassword(@RequestBody NewPasswordPojo newPasswordPojo){
        userService.setNewPassword(newPasswordPojo);
        return "password changed";
    }

}
