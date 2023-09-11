package com.example.mydemo.user;

import com.example.mydemo.model.User;

import java.util.List;

public interface UserService {
    Object saveUser(User user);
    List<User> getAllUser();
    User getUserById(Long id);
}
