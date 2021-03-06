package com.ss.retraining.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "fields")
public class Fields implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "field_type")
    private int fieldType;

    @Column(name = "is_strict")
    private Boolean isStrict;

    @Column(name = "created")
    private LocalDateTime created;

    @OneToMany(mappedBy = "fieldsEntity")
    private List<FormFields> formFields;

    @OneToMany(mappedBy = "fields")
    private List<ChoiceOptions> choiceOptions;

    @OneToMany(mappedBy = "fieldsEntity")
    private List<SharedFields> sharedFields;

    @OneToMany(mappedBy = "fields")
    private List<SettingsAutocomplete> settingsAutocomplete;

    @ManyToMany
    @JoinTable(name = "field_range",
            joinColumns = @JoinColumn(name = "range_id"),
            inverseJoinColumns = @JoinColumn(name = "field_id"))
    private List<Ranges> ranges;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Users owners;
}

