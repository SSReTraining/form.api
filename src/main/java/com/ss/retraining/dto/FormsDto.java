package com.ss.retraining.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by annakitchak on 23.04.20.
 */


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class FormsDto {

    private Long id;

    private String formName;

    private String formTitle;

    private String resultsUrl;

    private boolean isPublished;

    private LocalDate created;

}
