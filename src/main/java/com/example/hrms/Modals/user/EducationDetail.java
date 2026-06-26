package com.example.hrms.Modals.user;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "education_detail")
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
