package com.ss.retraining.repository;

import com.ss.retraining.entity.SharedFields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SharedFieldsRepository extends JpaRepository<SharedFields,Long> {
    List<SharedFields> getAllByFieldsEntity_Owners_Id(Long id);
    List<SharedFields> getAllByFieldsEntity_Id(Long id);
    SharedFields getByFieldsEntity_IdAndAndUsers_Id(Long fieldsId,Long usersId);

    @Modifying
    @Query(value = "INSERT INTO SharedFields (field_id, owner_id, user_id) VALUES (:fid, :oid, :uid)",nativeQuery = true)
    void saveByIds(@Param("fid")Long fid,@Param("oid")Long oid,@Param("uid")Long uid);
}
