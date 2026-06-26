package com.example.hrms.dto.user_dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;

}
