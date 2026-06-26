package com.example.hrms.Modals.user;

import com.example.hrms.enums.MaritalStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personal_detail")
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fatherName;
    private String motherName;
    @NotBlank
    @Column(nullable = false)
    @Size(min = 3, max = 50)
    private String gender;

    @NotNull
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;
    private String nationality;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
