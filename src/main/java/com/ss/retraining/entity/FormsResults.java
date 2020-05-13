package com.ss.retraining.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "formresults")
public class FormsResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column (name="answers")
    private String answers;

    @Column (name = "created")
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name="form_id")
    private Forms forms;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users owners;
}
