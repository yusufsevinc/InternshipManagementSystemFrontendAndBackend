package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NeighborhoodResponseDTO extends NeighborhoodDTO {

    private Long neighborhoodId;
    private DistrictResponseDTO district;

}
