package com.ss.retraining.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "formresults")

public class FormsResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column (name="user_id")
    private long user_id;

    @Column (name="token_id")
    private long token_id;

    @Column (name="answers")
    private String answers;

    @Column (name = "created")
    private Timestamp created;

    @ManyToOne
    @JoinColumn(name = "id")
    private Users owners;
}
