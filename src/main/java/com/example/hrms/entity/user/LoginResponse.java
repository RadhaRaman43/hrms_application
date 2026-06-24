package com.example.hrms.entity.user;

import lombok.Data;

@Data
public class LoginResponse {

    private boolean status;
    private String message;
    private String token;
    private User user;

    public LoginResponse(boolean status, String message, String token, User user) {
        this.status = status;
        this.message = message;
        this.token = token;
        this.user = user;

    }


}