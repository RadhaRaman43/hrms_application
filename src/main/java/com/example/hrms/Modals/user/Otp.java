package com.example.hrms.Modals.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Otp {
    @Id
    @GeneratedValue
    private Long id;

    private String emailOrPhone;
    private String otp;
    private LocalDateTime expiryTime;
    private boolean used;
}

