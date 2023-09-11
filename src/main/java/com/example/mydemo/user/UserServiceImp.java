package com.example.mydemo.user;

import com.example.mydemo.model.User;
import com.example.mydemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    public Object saveUser(User user) {
//        User user1=new User();
        return userRepository.save(user).getId();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException
                        ("User does not exist by given id" + id));
    }

//    private List<Object>
}
