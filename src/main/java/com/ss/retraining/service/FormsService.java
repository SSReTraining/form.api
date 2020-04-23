package com.ss.retraining.service;

import java.util.List;

import com.ss.retraining.entity.Forms;

/**
 * Created by annakitchak on 23.04.20.
 */


public interface FormsService {

    void save(Forms forms) throws Exception;

    void update(Forms forms);

    void delete(Long id);

    Forms findOne(Long id);

    List<Forms> findAll();

}
