package com.javalearning.webapp.controller;

import com.javalearning.webapp.model.User;
import com.javalearning.webapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/createUsers")
    public String createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @PostMapping("/updateUsers")
    public void updateUsers(@RequestBody User user){
        userService.updateUserDetails(user);
    }
    @DeleteMapping("/{id}")
    public <Long> String deleteCustomer(@PathVariable Long id){
        return userService.deleteUser((java.lang.Long) id);
    }
}
