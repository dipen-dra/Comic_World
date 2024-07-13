package com.example.comicworldbackend;

import com.example.comicworldbackend.Entity.User;

import com.example.comicworldbackend.Repo.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUser(){
        User user = new User();

        user.setFullName("Nirajan Mahato");
        user.setEmail("nirajanmahato44@gmail.com");
        user.setPassword("Nirajan@123");

        user = userRepo.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void findById(){
        User user = userRepo.findById(1L).get();

        Assertions.assertThat(user.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void findAll(){
        List<User> userList = userRepo.findAll();

        Assertions.assertThat(userList.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updateUser(){
        User user = userRepo.findById(1L).get();

        user.setFullName("Nirajan Mahato2");
        user.setEmail("nirajanmahato44@outlook.com");
        user.setPassword("Nirajan@12");

        user = userRepo.save(user);

        Assertions.assertThat(user.getFullName()).isEqualTo("Nirajan Mahato2");
        Assertions.assertThat(user.getEmail()).isEqualTo("nirajanmahato44@outlook.com");
        Assertions.assertThat(user.getPassword()).isEqualTo("Nirajan@12");
    }

    @Test
    @Order(5)
    public void deleteById(){
        userRepo.deleteById(1L);

        User user1 = null;
        Optional<User> user = userRepo.findById(1L);
        if(user.isPresent()){
            user1 = user.get();
        }

        Assertions.assertThat(user1).isNull();
    }
}
