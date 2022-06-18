package com.sevinc.intership_management_system.convert;

import com.sevinc.intership_management_system.dto.NeighborhoodResponseDTO;
import com.sevinc.intership_management_system.dto.NeighborhoodSaveDTO;
import com.sevinc.intership_management_system.dto.NeighborhoodSaveIdDTO;
import com.sevinc.intership_management_system.model.District;
import com.sevinc.intership_management_system.model.Neighborhood;
import com.sevinc.intership_management_system.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class NeighborhoodConverter {

    private final DistrictConverter districtConverter;
    private final DistrictService districtService;


    public Neighborhood neighborhoodConverter(NeighborhoodSaveDTO neighborhoodSaveDto) {
        Neighborhood neighborhood = new Neighborhood();
        District district = districtConverter.districtConverter(neighborhoodSaveDto.getDistrictSaveDto());

        neighborhood.setNeighborhoodKey(neighborhoodSaveDto.getNeighborhoodKey());
        neighborhood.setNeighborhoodName(neighborhoodSaveDto.getNeighborhoodName());
        neighborhood.setDistrict(district);

        return neighborhood;
    }

    @Transactional(readOnly = true)
    public Neighborhood neighborhoodConverter(NeighborhoodSaveIdDTO neighborhoodSaveIdDto) {
        Neighborhood neighborhood = new Neighborhood();
        District district = districtService.getByDistrictId(neighborhoodSaveIdDto.getDistrictId());

        neighborhood.setNeighborhoodKey(neighborhoodSaveIdDto.getNeighborhoodKey());
        neighborhood.setNeighborhoodName(neighborhoodSaveIdDto.getNeighborhoodName());
        neighborhood.setDistrict(district);

        return neighborhood;
    }

    public NeighborhoodResponseDTO neighborhoodConverter(Neighborhood neighborhood) {
        NeighborhoodResponseDTO neighborhoodResponseDto = new NeighborhoodResponseDTO();

        neighborhoodResponseDto.setNeighborhoodId(neighborhood.getNeighborhoodId());
        neighborhoodResponseDto.setNeighborhoodKey(neighborhood.getNeighborhoodKey());
        neighborhoodResponseDto.setNeighborhoodName(neighborhood.getNeighborhoodName());
        neighborhoodResponseDto.setDistrict(districtConverter.convertDistrictDto(neighborhood.getDistrict()));

        return neighborhoodResponseDto;
    }


}
