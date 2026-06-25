package com.example.hrms.entity.user;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bank_detail")
@Data
public class BankDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;
    private String accountNumber;
    private String ifscCode;
    private String accountHolderName;
    private String branchName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
