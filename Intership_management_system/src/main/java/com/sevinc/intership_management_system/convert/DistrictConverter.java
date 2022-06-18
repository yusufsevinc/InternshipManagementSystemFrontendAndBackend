package com.sevinc.intership_management_system.convert;

import com.sevinc.intership_management_system.dto.CityResponseDTO;
import com.sevinc.intership_management_system.dto.DistrictResponseDTO;
import com.sevinc.intership_management_system.dto.DistrictSaveDTO;
import com.sevinc.intership_management_system.model.City;
import com.sevinc.intership_management_system.model.District;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DistrictConverter {

    private final ModelMapper modelMapper;
    private final CityConverter cityConverter;

    public DistrictResponseDTO convertDistrictDto(District district) {
        CityResponseDTO cityResponseDto = modelMapper.map(district.getCity(), CityResponseDTO.class);

        DistrictResponseDTO districtDto = new DistrictResponseDTO();
        districtDto.setDistrictId(district.getDistrictId());
        districtDto.setDistrictKey(district.getDistrictKey());
        districtDto.setDistrictName(district.getDistrictName());
        districtDto.setCity(cityResponseDto);

        return districtDto;
    }

    public DistrictResponseDTO convertDistrictSaveDto(District district) {

        CityResponseDTO cityResponseDto = cityConverter.convertCitySaveDto(district.getCity());

        DistrictResponseDTO districtDto = new DistrictResponseDTO();
        districtDto.setDistrictKey(district.getDistrictKey());
        districtDto.setDistrictName(district.getDistrictName());
        districtDto.setCity(cityResponseDto);

        return districtDto;
    }

    public District districtConverter(DistrictSaveDTO districtSaveDto) {
        City city = modelMapper.map(districtSaveDto.getCity(), City.class);

        District district = new District();
        district.setDistrictKey(districtSaveDto.getDistrictKey());
        district.setDistrictName(districtSaveDto.getDistrictName());
        district.setCity(city);

        return district;
    }
}
