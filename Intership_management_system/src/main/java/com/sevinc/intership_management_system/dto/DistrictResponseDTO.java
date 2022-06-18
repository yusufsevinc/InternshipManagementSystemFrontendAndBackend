package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistrictResponseDTO extends DistrictDTO {

    private Long districtId;
    private CityResponseDTO city;


}
