package com.example.hrms.Modals.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String icon;

    private String type;

    private String link;

    private Integer orderNo;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Menu parent;
}
