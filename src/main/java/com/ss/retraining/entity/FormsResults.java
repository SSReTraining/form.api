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



    @Column (name="token_id")
    private long tokenId;

    @Column (name="answers")
    private String answers;

    @Column (name = "created")
    private Timestamp created;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users owners;
}
