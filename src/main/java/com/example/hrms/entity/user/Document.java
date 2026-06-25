package com.example.hrms.entity.user;

import jakarta.persistence.*;

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
