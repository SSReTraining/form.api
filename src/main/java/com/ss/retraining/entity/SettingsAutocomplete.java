package com.ss.retraining.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "settingsautocomlete")
public class SettingsAutocomplete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "field_id")
    private Long field_id;

    @Column(name = "data_url")
    private String data_url;

    @Column(name = "sheet")
    private String sheet;

    @Column(name = "from_user")
    private String from;

    @Column(name = "to_user")
    private String to;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Fields fields;

}