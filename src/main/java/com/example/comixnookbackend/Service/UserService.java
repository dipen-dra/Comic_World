package com.example.comixnookbackend.Service;


import com.example.comixnookbackend.Entity.User;
import com.example.comixnookbackend.Pojo.NewPasswordPojo;
import com.example.comixnookbackend.Pojo.UserPojo;

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
