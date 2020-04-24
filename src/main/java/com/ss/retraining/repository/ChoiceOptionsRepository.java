package com.ss.retraining.repository;

import com.ss.retraining.entity.ChoiceOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceOptionsRepository extends JpaRepository<ChoiceOptions, Long> {
}
