package com.example.onlinelearning.mapper;

import com.example.onlinelearning.dto.UserDto;
import com.example.onlinelearning.entity.User;
import org.mapstruct.Mapper;

/**
 * Maps User entity to UserDto
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    // DTO -> Entity
    User toEntity(UserDto userDto);

    // Entity -> DTO
    UserDto toDto(User user);


}
