package com.ss.retraining.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "fields")
public class Fields {
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
    private Timestamp created;

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
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "field_id"))
    private List<Fields> fields;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Users owners;
}

