package com.ss.retraining.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by annakitchak on 23.04.20.
 */

@Data
public class FormsDto {

    private Long id;

    private String formName;

    private String formTitle;

    private String resultsUrl;

    private boolean isPublished;

    private LocalDateTime created;

}
