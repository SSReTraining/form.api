package com.ss.retraining.service.impl;

import com.ss.retraining.dto.FormsDto;
import com.ss.retraining.entity.Forms;
import com.ss.retraining.repository.FormsRepository;
import com.ss.retraining.service.FormsService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class FormsServiceImpl implements FormsService {

    @Autowired
    private FormsRepository formsRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private SessionFactory sessionFactory;

    private FormsDto convertToDto(Forms forms) {
        FormsDto formsDto = modelMapper.map(forms, FormsDto.class);
        return formsDto;
    }

    private Forms convertToEntity(FormsDto formsDto) {
        Forms forms = modelMapper.map(formsDto, Forms.class);
        return forms;
    }


    @Override
    public void createForms(FormsDto formsDto) {
        formsRepository.save(convertToEntity(formsDto));
    }

    @Override
    public void updateForms(FormsDto formsDto) {
        Forms forms = convertToEntity(formsDto);
        formsRepository.save(forms);
    }

    @Override
    public void deleteFormsById(Long id) {
        formsRepository.deleteById(id);
    }

    @Override
    public FormsDto getFormsById(Long id) {
        return convertToDto(formsRepository.getOne(id));
    }

    @Override
    public List<FormsDto> getAllForms() {
//        return sessionFactory.getCurrentSession().createQuery("From Forms").list().stream().map(this::convertToDto).collect(Collectors.toList());
        Query query =  sessionFactory.getCurrentSession().createQuery("From Forms");
        List<Forms> forms = new LinkedList<>();
        for(final Object o : query.list()) {
            forms.add((Forms)o);
        }
        return forms.stream().map(this::convertToDto).collect(Collectors.toList());
//        List<Forms> forms = formsRepository.findAll();
//        return forms.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
