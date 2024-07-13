package com.example.comicworldbackend.Service.Impl;


import com.example.comicworldbackend.Config.PasswordEncoderUtil;
import com.example.comicworldbackend.Entity.User;
import com.example.comicworldbackend.Pojo.NewPasswordPojo;
import com.example.comicworldbackend.Pojo.UserPojo;
import com.example.comicworldbackend.Repo.UserRepository;
import com.example.comicworldbackend.Service.UserService;
import com.example.comicworldbackend.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final JwtService jwtService;
    private final UserRepository userRepository;



    @Override
    public void save(UserPojo userPojo) {
        User user = new User();

        if(userPojo.getId()!=null){
            user=userRepository.findById(userPojo.getId()).get();
        }
        user.setFullName(userPojo.getFullName());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
        user.setEmail(userPojo.getEmail());


        userRepository.save(user); // insert query
//        return "Saved Successfully";
    }

    @Override
    public List<User> getAll() {

        return userRepository.findAll(); // select * from users
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id); // delete from users where id =?1
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public String setNewPassword(NewPasswordPojo newPasswordPojo) {
        String email=jwtService.extractUsername(newPasswordPojo.getToken());
        User user=userRepository.findByEmail(email).get();
        user.setPassword(PasswordEncoderUtil.getInstance().encode(newPasswordPojo.getNewPassword()));
        userRepository.save(user);
        return null;
    }
}
