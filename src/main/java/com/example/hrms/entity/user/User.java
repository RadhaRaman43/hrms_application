package com.example.hrms.entity.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //basic information
    @NotBlank
    @Size(min = 3, max = 150)
    @Column(nullable = false)
    private String username;
    @NotBlank
    @Size(min = 3, max = 50)
    @Column(nullable = false)
    private String firstname;
    private String middlename;
    @NotBlank
    @Size(min = 3, max = 50)
    @Column(nullable = false)
    private String lastname;
    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;
    private String personalEmail;
    @NotBlank
    private String password;
    //personal detail
    private String panNo;
    private String adharCardNo;
    @NotBlank
    @Column(nullable = false, unique = true)
    @Size(min = 10, max = 10)
    private String phoneNo;
    private String otherMobileNo;
    @NotBlank
    @Column(nullable = false)
    @Size(min = 3, max = 50)
    private String gender;
    @NotNull
    private LocalDate dob;

    // organization details
    @NotBlank
    @Column(nullable = false)
    private String department;
    @NotBlank
    @Column(nullable = false)
    private String designation;
    @NotBlank
    @Column(unique = true, nullable = false)
    private String employeeId;
    private String isHo;
    private String locationId;
    private String shiftCode;
    private String managerId;
    private String grade;
    private String block;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime joining_date;
    @UpdateTimestamp
    private LocalDateTime updated_date;
    private String role;
    private Boolean isActive;
    private String companyId;
    private String profile;
    private String userType;

    private Integer passwordExpiryDays;

    @NotBlank
    @Column(nullable = false)
    @Size(min = 3, max = 500)
    private String address1;
    @NotBlank
    @Column(nullable = false)
    @Size(min = 3, max = 500)
    private String address2;
    @NotBlank
    @Column(nullable = false)
    @Size(min = 3, max = 100)
    private String city;
    @NotBlank
    @Column(nullable = false)
    @Size(min = 3, max = 16)
    private String postCode;
    @NotBlank
    @Column(nullable = false)
    @Size(min = 3, max = 50)
    private String State;

    @NotBlank
    @Column(nullable = false)
    private String deviceId;

    @Lob
    private String menu;

}
