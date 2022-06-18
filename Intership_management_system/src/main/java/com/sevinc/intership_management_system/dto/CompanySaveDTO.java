package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanySaveDTO extends CompanyDTO {

    private AddressSaveDTO address;
}
