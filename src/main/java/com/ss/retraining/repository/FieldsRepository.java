package com.ss.retraining.repository;

import com.ss.retraining.entity.Fields;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldsRepository extends JpaRepository<Fields, Long> {
    List<Fields> getAllByOwners_Username(String name);
}
