package com.example.hrms.Modals.user;

import jakarta.persistence.*;


@Entity
@Table(name = "role_menu")
public class RoleMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Menu menu;
}
