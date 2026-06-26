package com.example.hrms.Modals.user;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "identical_detail")
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
