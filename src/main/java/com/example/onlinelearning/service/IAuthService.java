package com.example.onlinelearning.service;

import com.example.onlinelearning.dto.request.LoginRequest;
import com.example.onlinelearning.dto.response.LoginResponse;

public interface IAuthService {
    LoginResponse login(LoginRequest loginRequest);
}
