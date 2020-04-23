package com.ss.retraining.service;

import com.ss.retraining.entity.Forms;

import java.util.List;

/**
 * Created by annakitchak on 23.04.20.
 */

public interface FormsService {

    void createForms(Forms forms) throws Exception;

    void updateForms(Forms forms, Long id);

    void deleteFormsById(Long id);

    Forms getFormsById(Long id);

    List<Forms> getAllForms();

}
