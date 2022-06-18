package com.sevinc.intership_management_system.convert;

import com.sevinc.intership_management_system.dto.AddressResponseDTO;
import com.sevinc.intership_management_system.dto.AddressSaveDTO;
import com.sevinc.intership_management_system.dto.AddressSaveIdDTO;
import com.sevinc.intership_management_system.dto.NeighborhoodResponseDTO;
import com.sevinc.intership_management_system.model.Address;
import com.sevinc.intership_management_system.model.Neighborhood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressConverter {

    private final NeighborhoodConverter neighborhoodConverter;

    public Address addressConverter(AddressSaveDTO addressSaveDto) {
        Address address = new Address();
        Neighborhood neighborhood = neighborhoodConverter.neighborhoodConverter(addressSaveDto.getNeighborhoodId());

        address.setStreetName(addressSaveDto.getStreetName());
        address.setEnabled(addressSaveDto.isEnabled());
        address.setApartmentNo(addressSaveDto.getApartmentNo());
        address.setNeighborhoodId(neighborhood);
        address.setDistrictId(neighborhood.getDistrict());
        address.setCityId(neighborhood.getDistrict().getCity());

        return address;
    }

    public AddressResponseDTO addressConverter(Address address) {
        AddressResponseDTO addressResponseDto = new AddressResponseDTO();
        NeighborhoodResponseDTO neighborhoodResponseDto = neighborhoodConverter.neighborhoodConverter(address.getNeighborhoodId());

        addressResponseDto.setAddressId(address.getAddressId());
        addressResponseDto.setApartmentNo(address.getApartmentNo());
        addressResponseDto.setEnabled(address.getEnabled());
        addressResponseDto.setStreetName(address.getStreetName());
        addressResponseDto.setNeighborhood(neighborhoodResponseDto);

        return addressResponseDto;
    }

    public Address addressConverter(AddressSaveIdDTO addressSaveIdDto, Neighborhood neighborhood) {

        Address address = new Address();

        address.setStreetName(addressSaveIdDto.getStreetName());
        address.setEnabled(addressSaveIdDto.isEnabled());
        address.setApartmentNo(addressSaveIdDto.getApartmentNo());
        address.setNeighborhoodId(neighborhood);
        address.setDistrictId(neighborhood.getDistrict());
        address.setCityId(neighborhood.getDistrict().getCity());

        return address;
    }
}
