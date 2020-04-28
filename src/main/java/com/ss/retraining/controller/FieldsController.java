package com.ss.retraining.controller;

import com.ss.retraining.dto.FieldDTO;
import com.ss.retraining.service.FieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fields")
public class FieldsController {
    @Autowired
    private FieldsService fieldsService;

    @GetMapping
    public List<FieldDTO> getAllFields() {
        return fieldsService.getAllFields();
    }

    @GetMapping("/{id}")
    public FieldDTO getByFieldsId(@PathVariable("id") Long id) {
        return fieldsService.getByFieldsId(id);
    }

    @PostMapping
    public void createFormFields(@RequestBody FieldDTO fieldDTO) {
        fieldsService.createFields(fieldDTO);
    }

    @DeleteMapping("/fields/{field_id}")
    public void deleteByFormFieldId(@PathVariable("field_id") Long fieldId) {
        fieldsService.deleteFieldsById(fieldId);
    }
    @PutMapping("/fields/{field_id}")
    public void updateFieldWithinAForm(@PathVariable("field_id") Long fieldId,
                                       @RequestBody FieldDTO fieldDTO)  {
        fieldDTO.setField(fieldId);
        fieldsService.updateFields(fieldDTO);
    }
}

