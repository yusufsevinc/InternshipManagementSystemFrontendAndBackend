package com.sevinc.intership_management_system.dto;

import lombok.Data;

@Data
public class UserLoginRequestDTO {
    private String email;
    private String password;
    private String fullName;
    private String role;
}
