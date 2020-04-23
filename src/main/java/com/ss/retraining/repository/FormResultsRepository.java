package com.ss.retraining.repository;

import com.ss.retraining.entity.FormsResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormResultsRepository extends JpaRepository<FormsResults,Long>{

}
