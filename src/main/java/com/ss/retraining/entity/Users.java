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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "owner_id")
    private List<SharedFields> shareFieldListOwners;

    @OneToMany(mappedBy = "user_id")
    private List<SharedFields> shareFieldListUsers;

    @OneToMany(mappedBy = "owner_id")
    private List<Forms> forms;

    @OneToMany(mappedBy = "user_id")
    private List<FormsResults> formsResults;

    private boolean isActive;

}
