package com.ss.retraining.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sharedfields")
public class SharedFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "field_id")
    private Fields fieldsEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Users owner;


}
