package com.sevinc.intership_management_system.repository;

import com.sevinc.intership_management_system.model.StudentIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentIdentityRepository extends JpaRepository<StudentIdentity, Long> {

    @Modifying
    @Query("DELETE FROM StudentIdentity si WHERE si.studentIdentityId = :studentIdentityId")
    void deleteStudentIdentityByStudentIdentityId(@Param("studentIdentityId") Long studentIdentityId);
}
