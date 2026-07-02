package com.example.hrms.Modals.user;

import jakarta.validation.constraints.*;
import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
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
    @NotBlank
    @Column(nullable = false, unique = true)
    @Size(min = 10, max = 10)
    private String phoneNo;
    private String otherMobileNo;

    // organization details
    @NotBlank
    @Column(nullable = false)
    private String department;
    @NotBlank
    @Column(nullable = false)
    private String designation;
    @NotBlank
    @Column(unique = true, nullable = false)
    private String userId;

    private String isHo;
    private String locationId;
    private String shiftCode;
    private String managerId;
    private String grade;
    private String block;

    @UpdateTimestamp
    private LocalDateTime updated_date;
    private String roleId;
    private String roleName;
    private Boolean isActive;
    private String companyId;
    private String profile;
    private String userType;

    private Integer passwordExpiryDays;
    @NotBlank
    @Column(nullable = false)
    private String deviceId;
    @Lob
    private String menu;

}
