package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyResponseDTO extends CompanyDTO {

    private Long companyId;
    private AddressResponseDTO address;
}
