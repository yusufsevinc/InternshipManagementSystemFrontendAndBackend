package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDTO {
    private Long id;
    private String email;
    private String token;
    private String fullName;
    private String role;
}
