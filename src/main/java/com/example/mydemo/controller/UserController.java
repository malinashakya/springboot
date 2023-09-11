package com.example.mydemo.controller;

import com.example.mydemo.model.User;
import com.example.mydemo.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public Object saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @GetMapping
    public Object getAllUser()
    {
        return userService.getAllUser();
    }
    @GetMapping("/{id}")
    public Object getUserById(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }
}
