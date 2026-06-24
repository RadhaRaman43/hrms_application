package com.example.hrms.dto.user_dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserProfileDTO {
    private String emailId;
    private MultipartFile imageUrl;
}