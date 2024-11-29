package com.group.security.authentication.dto;

import lombok.Getter;

@Getter
public class SignupDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
