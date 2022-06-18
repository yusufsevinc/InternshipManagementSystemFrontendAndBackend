package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.dto.NeighborhoodResponseDTO;
import com.sevinc.intership_management_system.dto.NeighborhoodSaveDTO;
import com.sevinc.intership_management_system.dto.NeighborhoodSaveIdDTO;
import com.sevinc.intership_management_system.model.Neighborhood;

import java.util.List;

public interface NeighborhoodService {
    NeighborhoodResponseDTO saveNeighborhood(NeighborhoodSaveDTO neighborhoodSaveDto);

    NeighborhoodResponseDTO saveNeighborhood(NeighborhoodSaveIdDTO neighborhoodSaveIdDto);

    List<NeighborhoodResponseDTO> getAllNeighborhood();

    List<NeighborhoodResponseDTO> getAllDistrictNeighborhood(Long id);

    NeighborhoodResponseDTO getByNeighborhoodDtoId(Long id);

    Neighborhood getByNeighborhoodId(Long id);

    Neighborhood getByNeighborhoodKey(Long id);
}
