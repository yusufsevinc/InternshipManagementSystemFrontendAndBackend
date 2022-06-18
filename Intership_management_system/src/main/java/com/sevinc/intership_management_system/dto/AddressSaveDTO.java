package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressSaveDTO extends AddressDTO {

    private NeighborhoodSaveDTO neighborhoodId;
}
