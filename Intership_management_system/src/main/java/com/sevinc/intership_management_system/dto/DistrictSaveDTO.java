package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistrictSaveDTO extends DistrictDTO {

    private CitySaveDTO city;

}
