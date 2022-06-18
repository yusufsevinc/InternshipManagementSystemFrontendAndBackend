package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.convert.DistrictConverter;
import com.sevinc.intership_management_system.dto.CityResponseDTO;
import com.sevinc.intership_management_system.dto.DistrictResponseDTO;
import com.sevinc.intership_management_system.dto.DistrictSaveDTO;
import com.sevinc.intership_management_system.dto.DistrictSaveIdDTO;
import com.sevinc.intership_management_system.exceptions.ServiceRuntimeException;
import com.sevinc.intership_management_system.model.City;
import com.sevinc.intership_management_system.model.District;
import com.sevinc.intership_management_system.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;
    private final ModelMapper modelMapper;
    private final CityService cityService;
    private final DistrictConverter districtConverter;

    @Override
    @Transactional
    public DistrictResponseDTO saveDistrict(DistrictSaveDTO districtSaveDto) {

        District district = modelMapper.map(districtSaveDto, District.class);
        CityResponseDTO cityResponseDto = cityService.saveCity(districtSaveDto.getCity());
        City city = modelMapper.map(cityResponseDto, City.class);
        district.setCity(city);
        district = districtRepository.save(district);

        return modelMapper.map(district, DistrictResponseDTO.class);
    }

    @Override
    @Transactional
    public DistrictResponseDTO saveDistrict(DistrictSaveIdDTO districtSaveIdDto) {

        final var city = cityService.getByCityId(districtSaveIdDto.getCityId());

        District district = modelMapper.map(districtSaveIdDto, District.class);
        district.setCity(city);
        district = districtRepository.save(district);

        DistrictResponseDTO districtResponseDto = modelMapper.map(district, DistrictResponseDTO.class);

        return districtResponseDto;
    }

    @Override
    @Transactional(readOnly = true)
    public DistrictResponseDTO getByDistrictDtoId(Long districtId) {
        final var district = districtRepository.findDistrictByDistrictId(districtId)
                .orElseThrow(() -> new ServiceRuntimeException("District Not Found"));
        CityResponseDTO cityResponseDto = modelMapper.map(district.getCity(), CityResponseDTO.class);
        DistrictResponseDTO districtDto = modelMapper.map(district, DistrictResponseDTO.class);
        districtDto.setCity(cityResponseDto);
        return districtDto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DistrictResponseDTO> getAllDistrict() {
        List<District> districtList = districtRepository.findAll();
        return districtList.stream()
                .map(district -> districtConverter.convertDistrictDto(district))
                .collect(Collectors.toList());
    }

    @Override
    public List<DistrictResponseDTO> getAllCityDistrict(Long id) {
        List<District> districtList = districtRepository.findDistrictByCity_CityKey(id);
        return districtList.stream()
                .map(district -> districtConverter.convertDistrictDto(district))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public District getByDistrictId(Long districtId) {
        final var district = districtRepository.findDistrictByDistrictId(districtId)
                .orElseThrow(() -> new ServiceRuntimeException("District Not Found"));
        return district;
    }

    @Override
    @Transactional(readOnly = true)
    public District getByDistrictKey(Long districtKey) {
        final var district = districtRepository.findDistrictByDistrictKey(districtKey)
                .orElseThrow(() -> new ServiceRuntimeException("District Not Found"));
        return district;
    }
}
