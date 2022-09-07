package com.ll.exam.sbb.user.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("회원가입이 가능하다.")
    public void t1() {
        userService.create("user1", "user1@email.com", "1234");

    }

}