package com.Nima.myai.service;


import com.Nima.myai.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    List<User> findAll();
    Optional<User> findById(Long id);
    void deleteById(Long id);
}