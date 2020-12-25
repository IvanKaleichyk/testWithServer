package com.koleychik.test_with_server.controllers;

import com.koleychik.test_with_server.models.User;
import com.koleychik.test_with_server.reposiroties.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public List<User> getAll(@RequestParam(defaultValue = "false") boolean orderByAge) {
        if (orderByAge) return userRepository.findAllOrderedByFirstName();
        return userRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<User> findByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }

    @PostMapping
    public User insert(@RequestBody User model) {
        return userRepository.save(model);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam long id) {
        userRepository.deleteById(id);
    }

}
