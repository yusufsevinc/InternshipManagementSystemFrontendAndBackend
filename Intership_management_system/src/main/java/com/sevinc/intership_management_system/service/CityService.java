package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.dto.CityResponseDTO;
import com.sevinc.intership_management_system.dto.CitySaveDTO;
import com.sevinc.intership_management_system.model.City;

import java.util.List;

public interface CityService {
    CityResponseDTO saveCity(CitySaveDTO citySaveDto);

    List<CityResponseDTO> getAllCity();

    CityResponseDTO getByCityResponseDtoId(Long cityId);

    City getByCityId(Long cityId);

    City getByCityKey(Long cityKey);
}
