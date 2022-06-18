package com.sevinc.intership_management_system.repository;

import com.sevinc.intership_management_system.model.CompanyExecutive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyExecutiveRepository extends JpaRepository<CompanyExecutive, Long> {

    @Query("SELECT ce  FROM CompanyExecutive ce WHERE ce.enabled = :enabled")
    List<CompanyExecutive> findCompanyExecutiveByCompanyExecutiveId(@Param("enabled") Boolean enabled);

    @Modifying
    @Query("DELETE FROM CompanyExecutive ce WHERE ce.companyExecutiveId = :companyExecutiveId")
    void deleteCompanyExecutiveByCompanyExecutiveId(@Param("companyExecutiveId") Long companyExecutiveId);

    @Query("SELECT ce FROM CompanyExecutive ce inner join Company c on ce.company.companyId = c.companyId WHERE ce.company.companyId = :companyId")
    List<CompanyExecutive>findCompanyExecutiveByCompanyId(@Param("companyId") Long companyId);

}
