package com.example.onlinelearning.service;

import com.example.onlinelearning.dto.request.CreateUserRequest;
import com.example.onlinelearning.dto.response.UserResponse;

public interface IUserService {

    UserResponse createUser(CreateUserRequest userRequest);


}
