package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.convert.CityConverter;
import com.sevinc.intership_management_system.dto.CityResponseDTO;
import com.sevinc.intership_management_system.dto.CitySaveDTO;
import com.sevinc.intership_management_system.exceptions.ServiceRuntimeException;
import com.sevinc.intership_management_system.model.City;
import com.sevinc.intership_management_system.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final CityConverter cityConverter;

    @Override
    @Transactional
    public CityResponseDTO saveCity(CitySaveDTO citySaveDto) {

        City city = modelMapper.map(citySaveDto, City.class);
        city = cityRepository.save(city);

        return cityConverter.convertCitySaveDto(city);

    }

    @Override
    @Transactional(readOnly = true)
    public List<CityResponseDTO> getAllCity() {
        List<City> cityList = cityRepository.findAll();
        return cityList.stream()
                .map(city -> cityConverter.convertCityDto(city))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CityResponseDTO getByCityResponseDtoId(Long cityId) {
        final var city = cityRepository.findCityByCityId(cityId)
                .orElseThrow(() -> new ServiceRuntimeException("City Not Found"));
        CityResponseDTO cityResponseDto = modelMapper.map(city, CityResponseDTO.class);
        return cityResponseDto;
    }

    @Override
    @Transactional(readOnly = true)
    public City getByCityId(Long cityId) {
        final var city = cityRepository.findCityByCityId(cityId)
                .orElseThrow(() -> new ServiceRuntimeException("City Not Found"));
        return city;
    }

    @Override
    @Transactional(readOnly = true)
    public City getByCityKey(Long cityKey) {
        final var city = cityRepository.findCityByCityKey(cityKey)
                .orElseThrow(() -> new ServiceRuntimeException("City Not Found"));
        return city;
    }


}
