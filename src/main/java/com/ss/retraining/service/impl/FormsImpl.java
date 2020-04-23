package com.ss.retraining.service.impl;

import com.ss.retraining.entity.Forms;
import com.ss.retraining.repository.FormsRepository;
import com.ss.retraining.service.FormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by annakitchak on 23.04.20.
 */


@Service
@Transactional
public class FormsImpl implements FormsService {

    @Autowired
    private FormsRepository formsRepository;

    @Override
    public void createForms(Forms forms) throws Exception {
        formsRepository.save(forms);
    }

    @Override
    public void updateForms(Forms forms,Long id) {
        forms.setId(forms.getId());
        formsRepository.save(forms);
    }

    @Override
    public void deleteFormsById(Long id) {
        formsRepository.deleteById(id);
    }

    @Override
    public Forms getFormsById(Long id) {
        return formsRepository.getOne(id);
    }

    @Override
    public List<Forms> getAllForms() {
        return formsRepository.findAll();
    }
}
