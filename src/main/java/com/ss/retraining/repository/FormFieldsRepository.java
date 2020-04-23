package com.ss.retraining.repository;

import com.ss.retraining.entity.FormFields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormFieldsRepository extends JpaRepository<FormFields,Long> {

}
