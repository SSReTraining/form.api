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
@Table(name = "ranges")
public class Ranges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="min_size")
    private int minSize;

    @Column(name="max_size")
    private int maxSize;

    @ManyToMany
    @JoinTable(name = "field_range",
            joinColumns = @JoinColumn(name = "field_id"),
            inverseJoinColumns = @JoinColumn(name = "range_id"))
    private List<Fields> fields;
}
