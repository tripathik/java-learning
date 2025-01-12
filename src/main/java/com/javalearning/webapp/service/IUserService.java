package com.javalearning.webapp.service;

import com.javalearning.webapp.model.User;

import java.util.List;

public interface IUserService {
    public String saveUser(User user);
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User updateUserDetails(User newUser);
    public String deleteUser(Long id);
}
