package com.ss.retraining.repository;

import com.ss.retraining.entity.Forms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by annakitchak on 22.04.20.
 */
@Repository
public interface FormsRepository extends JpaRepository<Forms, Long> {

}
