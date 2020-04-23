package com.ss.retraining.repository;


import com.ss.retraining.entity.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RangeRepository extends JpaRepository<Range, Long>{

}
