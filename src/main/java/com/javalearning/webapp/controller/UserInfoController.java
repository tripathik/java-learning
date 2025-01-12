package com.javalearning.webapp.controller;

import com.javalearning.webapp.model.User;
import com.javalearning.webapp.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserInfoController {

    private final IUserService userService;
    public UserInfoController(IUserService userService){
        this.userService=userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }

    @GetMapping("/users/new")
    public String createUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "create_user";
    }

    @PostMapping("/users")
    public String saveUsers(@ModelAttribute("users") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "edit_user";
    }
    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Long id,
                             @ModelAttribute("user") User user,
                             Model model){
        userService.updateUserDetails(user);
        return "redirect:/users";
    }
    @GetMapping("/users/{id}")
    public String deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
