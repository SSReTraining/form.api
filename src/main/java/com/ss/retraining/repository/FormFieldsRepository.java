package com.ss.retraining.repository;

import com.ss.retraining.entity.FormFields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormFieldsRepository extends JpaRepository<FormFields,Long> {
List<FormFields> getAllByFormEntity_Id(Long id);
}
