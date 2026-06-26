package com.example.hrms.Modals.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "children_details")
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
