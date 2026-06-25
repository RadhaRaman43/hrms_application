package com.example.hrms.entity.user;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "education_detail")
@Data
public class EducationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String degree;
    private String instituteName;
    private String boardUniversity;
    private Double percentage;
    private Integer passingYear;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
