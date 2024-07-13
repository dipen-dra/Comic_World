package com.example.comixnookbackend;

import com.example.comixnookbackend.Entity.User;
import com.example.comixnookbackend.Repo.UserRepository;
import com.example.comixnookbackend.Service.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
public class UserStepDefinitions {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Given("getAll")
    public void getall() {
        List<User> allUser = userService.getAll();
        log.info(allUser);
        Assert.assertTrue(!allUser.isEmpty());
    }


    @Given("getById")
    public void getbyid() {
        userService.getById(1L);
        System.out.println("user fetch successfully");
    }

    @Given("post data")
    public void post_data() {
    }

    @Given("verify")
    public void verify() {
    }

    @Then("finally")
    public void finally1() {
    }
}
