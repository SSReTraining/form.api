package com.ss.retraining.repository;

import com.ss.retraining.entity.SharedFields;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SharedFieldsRepository extends JpaRepository<SharedFields,Long> {
    List<SharedFields> getAllByFieldsEntity_Owners_Id(Long id);
    List<SharedFields> getAllByFieldsEntity_Id(Long id);
    SharedFields getByFieldsEntity_IdAndAndUsers_Id(Long fieldsId,Long usersId);
}
