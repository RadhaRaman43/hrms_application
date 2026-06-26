package com.example.hrms.dto.user_dto;

import com.example.hrms.Modals.user.User;
import lombok.Data;

@Data
public class LoginResponseDto {
    private boolean status;
    private String message;
    private String token;
    private User user;

    public LoginResponseDto(boolean status, String message, String token, User user) {
        this.status = status;
        this.message = message;
        this.token = token;
        this.user = user;
    }


}