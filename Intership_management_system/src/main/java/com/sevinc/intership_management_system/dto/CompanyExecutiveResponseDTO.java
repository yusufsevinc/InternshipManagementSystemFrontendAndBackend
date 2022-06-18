package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyExecutiveResponseDTO extends CompanyExecutiveDTO {
    private Long companyExecutiveId;
    private CompanyResponseDTO company;
}
