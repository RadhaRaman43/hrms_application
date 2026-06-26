package com.example.hrms.Modals.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_detail")
public class BankDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String bankName;

    @NotBlank
    @Column(nullable = false)
    private String accountHolderName;

    @NotBlank
    @Column(nullable = false)
    private String accountNumber;

    @NotBlank
    @Column(nullable = false)
    private String ifscCode;

    private String branchName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
