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
@Table(name = "range")
public class Range {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="min")
    private int min;

    @Column(name="max")
    private int max;

//    @ManyToMany(cascade = CascadeType.DETACH)
//    @JoinTable(name = "field_range",
//            joinColumns = @JoinColumn(name = "field_id"),
//            inverseJoinColumns = @JoinColumn(name = "id"))
//    private List<Range> range;
}
