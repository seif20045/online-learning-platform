package com.example.onlinelearning.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents a system user (Student, Instructor, Admin)
 */

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // User full name
    private String name;

    // User email (should be unique)
    @Column(unique = true)
    private String email;

    // User password (will be encrypted later)
    private String password;

    // User role (STUDENT, INSTRUCTOR, ADMIN)
    private String role;


}
