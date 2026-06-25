package com.example.hrms.entity.user;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String designation;

    private LocalDate joiningDate;
    private LocalDate relievingDate;

    private Double salary;

    private String jobDescription;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
