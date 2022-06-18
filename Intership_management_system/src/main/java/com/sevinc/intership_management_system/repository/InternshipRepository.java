package com.sevinc.intership_management_system.repository;

import com.sevinc.intership_management_system.model.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternshipRepository extends JpaRepository<Internship ,Long> {

    @Modifying
    @Query("Select i from Internship i where i.approvedId.assistantDean = TRUE AND i.approvedId.commission = TRUE AND i.approvedId.headOfDepartment = TRUE")
    List<Internship> approvedIntership();
}
