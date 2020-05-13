package com.ss.retraining.controller;

import com.ss.retraining.dto.FieldDTO;
import com.ss.retraining.service.FieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/fields")
public class    FieldsController {
    @Autowired
    private FieldsService fieldsService;

    @GetMapping
    public List<FieldDTO> getAllUserFields() {

        return
                fieldsService.getAllFieldsByUser();
    }

    @GetMapping("/{id}")
    public FieldDTO getByFieldsId(@PathVariable("id") Long id) {
        return fieldsService.getByFieldsId(id);
    }

    @PostMapping
    public void createFields(@RequestBody FieldDTO fieldDTO) {
        fieldsService.createFields(fieldDTO);
    }

    @DeleteMapping("/{field_id}")
    public void deleteByFieldId(@PathVariable("field_id") Long fieldId) {
        fieldsService.deleteFieldsById(fieldId);
    }

    @PutMapping("/{field_id}")
    public void updateFields(@PathVariable("field_id") Long fieldId,
                                       @RequestBody FieldDTO fieldDTO)  {
        fieldDTO.setId(fieldId);
        fieldsService.updateFields(fieldDTO);

    }

}

