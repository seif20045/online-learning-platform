package com.example.onlinelearning.dto;

import lombok.Data;

/**
 * Used to send safe user data in APIs
 */

@Data
public class UserDto {

    private Integer id;
    private String name;
    private String email;
    private String role;


}
