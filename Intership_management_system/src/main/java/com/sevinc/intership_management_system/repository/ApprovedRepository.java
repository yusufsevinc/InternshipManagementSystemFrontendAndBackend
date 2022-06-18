package com.sevinc.intership_management_system.repository;

import com.sevinc.intership_management_system.model.Approved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApprovedRepository extends JpaRepository<Approved,Long> {

    @Modifying
    @Query("DELETE FROM Approved a WHERE  a.approvedId = :approvedId")
    void deleteApprovedByApprovedId (@Param("approvedId") Long approvedId);

    @Modifying
    @Query("UPDATE Approved a SET a.assistantDean = true WHERE a.approvedId = :approvedId")
    void updateAssistantDean(@Param("approvedId") Long approvedId);

    @Modifying
    @Query("UPDATE Approved a SET a.commission = true WHERE a.approvedId = :approvedId")
    void updateCommission(@Param("approvedId") Long approvedId);

    @Modifying
    @Query("UPDATE Approved a SET a.headOfDepartment = true WHERE a.approvedId = :approvedId")
    void updateHeadOfDepartment(@Param("approvedId") Long approvedId);
}
