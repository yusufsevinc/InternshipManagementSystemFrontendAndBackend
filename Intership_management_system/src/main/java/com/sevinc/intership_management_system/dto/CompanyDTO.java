package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDTO {
    private String companyName;
    private String companyPhone;
    private String companyEmail;
    private Boolean enabled;
}
