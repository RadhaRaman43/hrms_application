package com.example.hrms.entity.user;

import com.example.hrms.enums.AddressType;
import jakarta.persistence.*;

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String houseNo;

    private String village;

    private String postOffice;

    private String tehsil;

    private String district;

    private String state;

    private String country;

    private String pinCode;

    private String landmark;

    @Enumerated(EnumType.STRING)
    private AddressType addressType; // CURRENT, PERMANENT

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
