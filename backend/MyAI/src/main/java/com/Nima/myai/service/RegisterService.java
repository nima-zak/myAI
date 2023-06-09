package com.Nima.myai.service;

import com.Nima.myai.dto.LoginRequest;
import com.Nima.myai.dto.RegisterRequest;
import com.Nima.myai.entity.User;

public interface RegisterService {
    User register(RegisterRequest registerRequest);
    User loginUser(LoginRequest loginRequest);
}
