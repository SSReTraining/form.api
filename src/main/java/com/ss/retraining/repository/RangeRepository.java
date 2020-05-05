package com.ss.retraining.repository;


import com.ss.retraining.entity.Ranges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RangeRepository extends JpaRepository<Ranges, Long>{

}
