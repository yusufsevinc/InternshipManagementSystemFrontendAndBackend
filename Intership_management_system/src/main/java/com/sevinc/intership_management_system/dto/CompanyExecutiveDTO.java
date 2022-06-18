package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyExecutiveDTO {

    private String companyExecutiveName;
    private String companyExecutiveSurname;
    private String companyExecutiveEmail;
    private String companyExecutiveTitle;
    private String companyExecutivePhone;
    private Boolean enabled;

}
