package com.example.onlinelearning.service.impl;

import com.example.onlinelearning.dto.request.CreateUserRequest;
import com.example.onlinelearning.dto.response.UserResponse;
import com.example.onlinelearning.entity.User;
import com.example.onlinelearning.mapper.UserMapper;
import com.example.onlinelearning.repository.UserRepository;
import com.example.onlinelearning.service.IUserService;
import com.example.onlinelearning.service.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;

    /**
     * @param userRequest
     * @return
     */
    @Override
    public UserResponse createUser(CreateUserRequest userRequest) {

        userValidator.validateCreateUser(userRequest.getEmail());

        User user = userMapper.toEntity(userRequest);
        User saveUser = userRepository.save(user);

        return userMapper.toResponse(saveUser);


    }
}
