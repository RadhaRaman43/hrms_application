package com.example.hrms.Modals.user;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(nullable = false, unique = true, length = 50)
    private String roleName;

    @Column(length = 200)
    private String description;

    @Column(nullable = false)
    private Boolean active = true;
    private Long parentMenuId;

//    @OneToMany(mappedBy = "role_id")
//    private List<User> users = new ArrayList<>();
}
