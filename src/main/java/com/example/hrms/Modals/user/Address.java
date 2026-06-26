package com.example.hrms.Modals.user;

import com.example.hrms.enums.AddressType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String houseNo;

    private String village;

    private String postOffice;

    private String tehsil;

    private String district;

    @NotBlank
    @Column(nullable = false)
    @Size(min = 3, max = 50)
    private String state;

    @NotBlank
    @Column(nullable = false)
    @Size(min = 3, max = 50)
    private String country;

    @NotBlank
    @Column(nullable = false)
    @Size(min = 6, max = 6)
    private String pinCode;

    private String landmark;

    @Enumerated(EnumType.STRING)
    private AddressType addressType; // CURRENT, PERMANENT

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
