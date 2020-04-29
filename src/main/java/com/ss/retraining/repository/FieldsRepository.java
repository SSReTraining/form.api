package com.ss.retraining.repository;

import com.ss.retraining.entity.Fields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldsRepository extends JpaRepository<Fields, Long> {
}
