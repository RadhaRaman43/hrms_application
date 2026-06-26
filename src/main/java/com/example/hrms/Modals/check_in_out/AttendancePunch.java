package com.example.hrms.Modals.check_in_out;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "AttendancePunch")
public class AttendancePunch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false,unique = true)
    private Long employeeId;

    @NotBlank
    @Column(nullable = false)
    private String attendanceSource; // W, M (Web, Mobile)
    @NotBlank
    @Column(nullable = false)
    private String attendanceType;   // Online, Offline
    private String requestType;      // A

    @NotBlank
    @Column(nullable = false)
    private String punchType; // IN / OUT

    @NotBlank
    @Column(nullable = false)
    private LocalDateTime punchTime;

    @NotBlank
    @Column(nullable = false)
    private String remarks;

    @NotBlank
    @Column(nullable = false)
    private Double latitude;
    @NotBlank
    @Column(nullable = false)
    private Double longitude;
    private String geoLocation;
    private String geoAccuracy;

    private String photo1Name;
    private String photo1Path;

    private String photo2Name;
    private String photo2Path;

    private LocalDateTime createdAt = LocalDateTime.now();
}
