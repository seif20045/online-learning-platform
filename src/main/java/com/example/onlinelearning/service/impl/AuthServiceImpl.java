package com.example.onlinelearning.service.impl;

import com.example.onlinelearning.dto.request.LoginRequest;
import com.example.onlinelearning.dto.request.RegisterRequest;
import com.example.onlinelearning.dto.response.LoginResponse;
import com.example.onlinelearning.dto.response.RegisterResponse;
import com.example.onlinelearning.entity.User;
import com.example.onlinelearning.exception.BusinessException;
import com.example.onlinelearning.repository.UserRepository;
import com.example.onlinelearning.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * @param loginRequest
     * @return
     */
    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() ->
                new BusinessException("Invalid email or password"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {

            throw new BusinessException("Invalid email or password");
        }

        LoginResponse response = new LoginResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        return response;
    }

    /**
     * @param registerRequest
     * @return
     */
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {

        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new BusinessException("Email already exists");
        }
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setName(registerRequest.getName());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        User saveuser = userRepository.save(user);

        RegisterResponse response = new RegisterResponse();
        response.setId(saveuser.getId());
        response.setEmail(saveuser.getEmail());
        response.setName(saveuser.getName());
        return response;

    }
}
