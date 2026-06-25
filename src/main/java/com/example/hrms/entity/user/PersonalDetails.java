package com.example.hrms.entity.user;

import com.example.hrms.enums.MaritalStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "personal_detail")
@Data
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fatherName;
    private String motherName;
    private String gender;

    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    private String nationality;

    @NotBlank
    @Column(nullable = false)
    @Size(min = 3, max = 500)
    private String currentAddress;
    @NotBlank
    @Column(nullable = false)
    @Size(min = 3, max = 500)
    private String permanentAddress;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
