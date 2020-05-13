package com.ss.retraining.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "owners")
    private List<SharedFields> shareFieldListOwners;

    @OneToMany(mappedBy = "users")
    private List<SharedFields> shareFieldListUsers;

    @OneToMany(mappedBy = "user")
    private List<Forms> forms;

    @OneToMany(mappedBy = "owners")
    private List<FormsResults> formsResults;

    @OneToMany(mappedBy = "owners")
    private List<Fields> fields;

    private boolean isActive;

}
