package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.convert.NeighborhoodConverter;
import com.sevinc.intership_management_system.dto.DistrictResponseDTO;
import com.sevinc.intership_management_system.dto.NeighborhoodResponseDTO;
import com.sevinc.intership_management_system.dto.NeighborhoodSaveDTO;
import com.sevinc.intership_management_system.dto.NeighborhoodSaveIdDTO;
import com.sevinc.intership_management_system.exceptions.ServiceRuntimeException;
import com.sevinc.intership_management_system.model.District;
import com.sevinc.intership_management_system.model.Neighborhood;
import com.sevinc.intership_management_system.repository.NeighborhoodRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NeighborhoodServiceImpl implements NeighborhoodService {

    private final ModelMapper modelMapper;
    private final NeighborhoodRepository neighborhoodRepository;
    private final DistrictService districtService;
    private final NeighborhoodConverter neighborhoodConverter;
    private List<Neighborhood> neighborhoodList;

    @Override
    @Transactional
    public NeighborhoodResponseDTO saveNeighborhood(NeighborhoodSaveDTO neighborhoodSaveDto) {
        Neighborhood neighborhood = neighborhoodConverter.neighborhoodConverter(neighborhoodSaveDto);
        DistrictResponseDTO districtResponseDto = districtService.saveDistrict(neighborhoodSaveDto.getDistrictSaveDto());
        District district = modelMapper.map(districtResponseDto, District.class);

        neighborhood.setDistrict(district);
        neighborhood = neighborhoodRepository.save(neighborhood);

        return neighborhoodConverter.neighborhoodConverter(neighborhood);
    }

    @Override
    @Transactional
    public NeighborhoodResponseDTO saveNeighborhood(NeighborhoodSaveIdDTO neighborhoodSaveIdDto) {
        Neighborhood neighborhood = neighborhoodConverter.neighborhoodConverter(neighborhoodSaveIdDto);
        neighborhood = neighborhoodRepository.save(neighborhood);
        return neighborhoodConverter.neighborhoodConverter(neighborhood);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NeighborhoodResponseDTO> getAllNeighborhood() {
        List<Neighborhood> neighborhoodList = neighborhoodRepository.findAll();
        return neighborhoodList.stream()
                .map(neighborhood -> neighborhoodConverter.neighborhoodConverter(neighborhood))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NeighborhoodResponseDTO> getAllDistrictNeighborhood(Long id) {
        List<Neighborhood> neighborhoodList = neighborhoodRepository.findNeighborhoodByDistrict_DistrictKey(id);
        return neighborhoodList.stream()
                .map(neighborhood -> neighborhoodConverter.neighborhoodConverter(neighborhood))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public NeighborhoodResponseDTO getByNeighborhoodDtoId(Long id) {
        final var neighborhood = neighborhoodRepository.findById(id)
                .orElseThrow(() -> new ServiceRuntimeException("Neighborhood Not Found"));

        NeighborhoodResponseDTO neighborhoodResponseDto = neighborhoodConverter.neighborhoodConverter(neighborhood);
        return neighborhoodResponseDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Neighborhood getByNeighborhoodId(Long id) {
        final var neighborhood = neighborhoodRepository.findById(id)
                .orElseThrow(() -> new ServiceRuntimeException("Neighborhood Not Found"));

        return neighborhood;
    }

    @Override
    @Transactional(readOnly = true)
    public Neighborhood getByNeighborhoodKey(Long id) {
        final var neighborhood = neighborhoodRepository.findNeighborhoodByNeighborhoodKey(id)
                .orElseThrow(() -> new ServiceRuntimeException("Neighborhood Not Found"));

        return neighborhood;
    }
}
