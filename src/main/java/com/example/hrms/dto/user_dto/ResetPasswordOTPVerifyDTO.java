package com.example.hrms.dto.user_dto;

import lombok.Data;

@Data
public class ResetPasswordOTPVerifyDTO {
    private String emailId;
    private String otpPassword;
    private String newUserPassword;
}
