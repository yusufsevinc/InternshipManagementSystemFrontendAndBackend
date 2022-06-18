package com.sevinc.intership_management_system.dto;

import com.sevinc.intership_management_system.model.HealthCovergeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentIdentityDTO {

    private String fatherName;
    private String motherName;
    private String birthPlace;
    private String birthDate;
    private HealthCovergeEnum healthCovergeEnum;

}
