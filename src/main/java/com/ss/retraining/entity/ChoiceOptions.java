package com.ss.retraining.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Table(name = "choiceoptions")
public class ChoiceOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "option_text")
    private String optionText;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Fields fields;
}

