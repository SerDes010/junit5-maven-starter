package com.dmdev.junit.service;

import com.dmdev.junit.dto.User;
import org.junit.jupiter.api.*;

import java.util.List;

import static junit.framework.Assert.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {

    private UserService userService;

    @BeforeAll
     void init() {
        System.out.println("Before all: " + this);
    }

    @BeforeEach
    void prepare() {
        System.out.println("Before each: " + this);
        userService = new UserService();
    }

    @Test
    void usersEmptyIfNoUserAdded() {
        System.out.println("Test1: " + this);

        var users = userService.getAll();
        userService.getAll();
        assertTrue("User list should be empty", users.isEmpty());
    }

    @Test
    void usersSizeIfUserAdded() {
        System.out.println("Test2: " + this);

        userService.add(new User());
        userService.add(new User());
        var users = userService.getAll();
        assertEquals(2,users.size());
    }

    @AfterEach
    void deleteDataFromDatabase() {
        System.out.println("After: " + this);
    }

    @AfterAll
    void closeConnectionPool() {
        System.out.println("After all "+this);
    }
}
