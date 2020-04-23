package com.ss.retraining.repository;

import com.ss.retraining.entity.FormResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormResultsRepository extends JpaRepository<FormResults,Long>{

}
