package com.example.hrms.Modals.user;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentType; // AADHAAR, PAN, RESUME

    private String documentNumber;

    private String filePath;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
