package com.ss.retraining.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by annakitchak on 22.04.20.
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="forms")
public class Forms {
    @Override
    public String toString() {
        return "Forms{" +
                "id=" + id +
                ", formName='" + formName + '\'' +
                ", formTitle='" + formTitle + '\'' +
                ", resultsUrl='" + resultsUrl + '\'' +
                ", isPublished=" + isPublished +
                ", created=" + created +
                ", user=" + user +
                ", formFields=" + formFields +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="formName")
    private String formName;

    @Column(name="formTitle")
    private String formTitle;

    @Column(name="resultsUrl")
    private String resultsUrl;

    @Column(name="isPublished")
    private boolean isPublished;

    @Column(name="created")
    private LocalDate created;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="owner_id")
    private Users user;

    @OneToMany(mappedBy="forms", cascade = CascadeType.REMOVE)
    private List<FormFields> formFields;

}
