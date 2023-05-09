package com.Nima.myai.controller;

import com.Nima.myai.dto.LoginRequest;
import com.Nima.myai.dto.RegisterRequest;
import com.Nima.myai.entity.User;
import com.Nima.myai.service.RegisterService;
import com.Nima.myai.exception.EmailAlreadyExistsException;
import com.Nima.myai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public ResponseEntity<String> ttt(){
        return ResponseEntity.ok("mmm");
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User registeredUser = registerService.register(registerRequest);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        if (ObjectUtils.isEmpty(loginRequest.getEmail()) || ObjectUtils.isEmpty(loginRequest.getPassword())) {
//            throw new LoginException(" username and password can not be empty");
        }

        User loginUser = registerService.loginUser(loginRequest);
        return ResponseEntity.ok(loginUser);
    }
}
