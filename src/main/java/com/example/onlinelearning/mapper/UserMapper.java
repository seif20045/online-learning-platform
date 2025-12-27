package com.example.onlinelearning.mapper;

import com.example.onlinelearning.dto.request.CreateUserRequest;
import com.example.onlinelearning.dto.response.UserResponse;
import com.example.onlinelearning.entity.User;
import org.mapstruct.Mapper;


/**
 * Maps User entity to request and response DTOs
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(CreateUserRequest userRequest);

    UserResponse toResponse(User user);


}
