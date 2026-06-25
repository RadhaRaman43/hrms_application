package com.example.hrms.entity.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "children_details")
@Data
public class ChildDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String childName;

    private LocalDate dateOfBirth;

    private String gender;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
