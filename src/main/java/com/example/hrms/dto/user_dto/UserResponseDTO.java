package com.example.hrms.dto.user_dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserResponseDTO {
    // basic info
    private String username;
    private String firstname;
    private String middlename;
    private String lastname;
    private String email;
    private String personalEmail;

    // personal
    private String phoneNo;
    private String otherMobileNo;

    // organization
    private String department;
    private String designation;
    private String userId;
    private String role;
    private String isHo;
    private String locationId;
    private String shiftCode;
    private String managerId;
    private String grade;
    private String block;
    private LocalDateTime joining_date;
    private String companyId;
    private String profile;
    private String userType;
    private Integer passwordExpiryDays;

}
