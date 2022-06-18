package com.sevinc.intership_management_system.convert;

import com.sevinc.intership_management_system.dto.CityResponseDTO;
import com.sevinc.intership_management_system.model.City;
import org.springframework.stereotype.Component;

@Component
public class CityConverter {

    public CityResponseDTO convertCityDto(City city) {
        CityResponseDTO cityResponseDto = new CityResponseDTO();
        cityResponseDto.setCityId(city.getCityId());
        cityResponseDto.setCityKey(city.getCityKey());
        cityResponseDto.setCityName(city.getCityName());
        return cityResponseDto;
    }

    public CityResponseDTO convertCitySaveDto(City city) {
        CityResponseDTO cityResponseDto = new CityResponseDTO();

        cityResponseDto.setCityId(city.getCityId());
        cityResponseDto.setCityKey(city.getCityKey());
        cityResponseDto.setCityName(city.getCityName());

        return cityResponseDto;
    }
}
