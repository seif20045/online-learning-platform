package com.example.onlinelearning.service.validator;

import com.example.onlinelearning.exception.BusinessException;
import com.example.onlinelearning.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepository userRepository;

    public void validateCreateUser(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new BusinessException("Email already exists");
        }

    }

}
