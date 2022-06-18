package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.dto.DistrictResponseDTO;
import com.sevinc.intership_management_system.dto.DistrictSaveDTO;
import com.sevinc.intership_management_system.dto.DistrictSaveIdDTO;
import com.sevinc.intership_management_system.model.District;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DistrictService {
    DistrictResponseDTO saveDistrict(DistrictSaveDTO districtSaveDto);

    DistrictResponseDTO saveDistrict(DistrictSaveIdDTO districtSaveDto);

    DistrictResponseDTO getByDistrictDtoId(Long districtId);

    List<DistrictResponseDTO> getAllDistrict();

    List<DistrictResponseDTO> getAllCityDistrict(Long id);

    District getByDistrictId(Long districtId);

    District getByDistrictKey(Long districtKey);
}
