package com.example.hrms.entity.user;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "identical_detail")
@Data
public class IdentityDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aadhaarNumber;

    private String panNumber;

    private String passportNumber;

    private String voterId;

    private String drivingLicenseNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
