package com.example.comixnookbackend;

import com.example.comixnookbackend.Entity.User;

import com.example.comixnookbackend.Repo.UserRepository;
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

        user.setFullName("Dipendra Ghimire");
        user.setEmail("dipendrajr999@gmail.com");
        user.setPassword("12345678");

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

        user.setFullName("Dipendra Ghimire");
        user.setEmail("dipendrajr999@gmail.com");
        user.setPassword("12345678");

        user = userRepo.save(user);

        Assertions.assertThat(user.getFullName()).isEqualTo("Dipendra Ghimire");
        Assertions.assertThat(user.getEmail()).isEqualTo("dipendrajr999@gmail.com");
        Assertions.assertThat(user.getPassword()).isEqualTo("12345678");
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
