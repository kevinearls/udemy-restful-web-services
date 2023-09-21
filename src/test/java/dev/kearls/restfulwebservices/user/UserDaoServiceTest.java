package dev.kearls.restfulwebservices.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoServiceTest {

   // @Autowired
    private UserDaoService userDaoService;

    @BeforeEach
    void setUp() {
        userDaoService = new UserDaoService();
    }

    @AfterEach
    void tearDown() {
        userDaoService = null;
    }

    @Test
    void findAll() {
        var allUsers = userDaoService.findAll();
        assertEquals(3, allUsers.size());
    }

    @Test
    void findOne() {
        var firstUser = userDaoService.findOne(1);
        assertEquals(1, firstUser.getId());
        assertEquals("Adam", firstUser.getName());
    }
}