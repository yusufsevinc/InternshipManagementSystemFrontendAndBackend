package com.sevinc.intership_management_system.repository;

import com.sevinc.intership_management_system.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT c  FROM Company c WHERE c.enabled = :enabled")
    List<Company> findCompanyByCompanyId(@Param("enabled") Boolean enabled);

    @Modifying
    @Query("DELETE FROM Company c WHERE c.companyId = :companyId")
    void deleteCompanyByCompanyId(@Param("companyId") Long companyId);
}
