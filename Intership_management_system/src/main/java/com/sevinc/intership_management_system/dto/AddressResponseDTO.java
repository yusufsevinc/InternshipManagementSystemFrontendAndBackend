package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponseDTO extends AddressDTO {
    private Long addressId;
    private NeighborhoodResponseDTO neighborhood;
}
