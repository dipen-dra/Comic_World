package com.example.comicworldbackend.Service;


import com.example.comicworldbackend.Entity.User;
import com.example.comicworldbackend.Pojo.NewPasswordPojo;
import com.example.comicworldbackend.Pojo.UserPojo;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(UserPojo userPojo);

    List<User> getAll();

    void deleteById(Long id);

    Optional<User> getById(Long id);
    Optional<User> getByEmail(String email);
    String setNewPassword(NewPasswordPojo newPasswordPojo);

}
