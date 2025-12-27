package com.example.onlinelearning.service;

import com.example.onlinelearning.dto.request.LoginRequest;
import com.example.onlinelearning.dto.request.RegisterRequest;
import com.example.onlinelearning.dto.response.LoginResponse;
import com.example.onlinelearning.dto.response.RegisterResponse;

public interface IAuthService {
    LoginResponse login(LoginRequest loginRequest);

    RegisterResponse register(RegisterRequest registerRequest);
}
