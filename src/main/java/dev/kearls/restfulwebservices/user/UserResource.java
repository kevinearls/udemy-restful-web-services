package dev.kearls.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    //@Autowired
    private UserDaoService userDaoService;

    public UserResource(UserDaoService service) {
        this.userDaoService = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveSpecificUser(@PathVariable int id) {
        return userDaoService.findOne(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userDaoService.save(user);
    }
}
