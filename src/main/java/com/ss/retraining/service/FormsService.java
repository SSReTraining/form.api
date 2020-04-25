package com.ss.retraining.service;

import com.ss.retraining.dto.FormsDto;

import java.util.List;


public interface FormsService {

    void createForms(FormsDto formsDto);

    void updateForms(FormsDto formsDto);

    void deleteFormsById(Long id);

    FormsDto getFormsById(Long id);

    List<FormsDto> getAllForms();

}
