package com.example.hrms.dto_request;

import jakarta.validation.constraints.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequestDto {
    @NotBlank(message = "First Name is required")
    @Size(min = 3, max = 50, message = "First Name must be between 3 and 50 characters")
    private String firstname;

    private String middlename;

    @NotBlank(message = "Last Name is required")
    @Size(min = 3, max = 50, message = "Last Name must be between 3 and 50 characters")
    private String lastname;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email")
    private String email;

    @Email(message = "Invalid Email")
    private String personalEmail;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must contain at least 6 characters")
    private String password;

    @NotBlank(message = "Phone Number is required")
    @Size(min = 10, max = 10, message = "Phone Number must be 10 digits")
    private String phoneNo;

    private String otherMobileNo;

    // Organization Details

    @NotBlank(message = "Department is required")
    private String department;

    @NotBlank(message = "Designation is required")
    private String designation;

    private String isHo;
    private String locationId;
    private String shiftCode;
    private String managerId;
    private String grade;
    private String block;

    private String roleName;
    private String companyId;

    private String profile;

    private String userType;


    @NotBlank(message = "Device Id is required")
    private String deviceId;
}
