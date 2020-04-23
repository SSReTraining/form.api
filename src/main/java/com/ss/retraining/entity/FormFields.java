package com.ss.retraining.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "formfields")
public class FormFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "position")
    private int position;

    @ManyToOne
    @JoinColumn(name = "forms_id")
    private Forms formEntity;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Fields fieldsEntity;

}
