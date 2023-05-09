package com.Nima.myai.service;

import com.Nima.myai.dto.LoginRequest;
import com.Nima.myai.dto.RegisterRequest;
import com.Nima.myai.entity.User;
import com.Nima.myai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public User register(RegisterRequest registerRequest) {
        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(registerRequest.getPassword());
//        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(newUser);
    }

    @Override
    public User loginUser(LoginRequest loginRequest) {
        return userRepository.getUserByEmail(loginRequest.getEmail());
    }
}
