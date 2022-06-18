package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressSaveFullIdDTO extends AddressDTO{
    private String apartmentNo ;
    private boolean addressEnabled;
    private String streetName;
    private Long cityKey ;
    private Long districtKey;
    private Long neighborhoodKey;
}
