package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.convert.AddressConverter;
import com.sevinc.intership_management_system.dto.AddressResponseDTO;
import com.sevinc.intership_management_system.dto.AddressSaveDTO;
import com.sevinc.intership_management_system.dto.AddressSaveFullIdDTO;
import com.sevinc.intership_management_system.dto.AddressSaveIdDTO;
import com.sevinc.intership_management_system.exceptions.ServiceRuntimeException;
import com.sevinc.intership_management_system.model.Address;
import com.sevinc.intership_management_system.model.Neighborhood;
import com.sevinc.intership_management_system.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressConverter addressConverter;
    private final AddressRepository addressRepository;
    private final NeighborhoodService neighborhoodService;
    private final CityService cityService;
    private final DistrictService districtService;

    @Override
    @Transactional
    public AddressResponseDTO saveAddress(AddressSaveDTO addressSaveDto) {

        Address address = addressConverter.addressConverter(addressSaveDto);
        address = addressRepository.save(address);
        return addressConverter.addressConverter(address);
    }

    @Override
    @Transactional
    public AddressResponseDTO saveAddress(AddressSaveIdDTO addressSaveIdDto) {
        Neighborhood neighborhood = neighborhoodService.getByNeighborhoodId(addressSaveIdDto.getNeighborhoodId());
        Address address = addressConverter.addressConverter(addressSaveIdDto, neighborhood);
        address = addressRepository.save(address);
        return addressConverter.addressConverter(address);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressResponseDTO> getAllAddress() {
        List<Address> addressList = addressRepository.findAll();
        return addressList.stream()
                .map(address -> addressConverter.addressConverter(address))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public AddressResponseDTO getByAddressResponseDtoId(Long addressId) {
        final var address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ServiceRuntimeException("Address Not Found"));
        AddressResponseDTO addressResponseDto = addressConverter.addressConverter(address);
        return addressResponseDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Address getByAddressId(Long addressId) {
        final var address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ServiceRuntimeException("Address Not Found"));
        return address;
    }

    @Override
    @Transactional
    public AddressResponseDTO saveAddress(AddressSaveFullIdDTO addressSaveFullIdDTO) {
        final var city  = cityService.getByCityKey(addressSaveFullIdDTO.getCityKey());
        final var district = districtService.getByDistrictKey(addressSaveFullIdDTO.getDistrictKey());
        final var neighborhood = neighborhoodService.getByNeighborhoodKey(addressSaveFullIdDTO.getNeighborhoodKey());

        Address address = new Address();

        address.setCityId(city);
        address.setDistrictId(district);
        address.setNeighborhoodId(neighborhood);
        address.setEnabled(addressSaveFullIdDTO.isEnabled());
        address.setApartmentNo(addressSaveFullIdDTO.getApartmentNo());
        address.setStreetName(addressSaveFullIdDTO.getStreetName());
        address = addressRepository.save(address);
        return addressConverter.addressConverter(address);

    }

    @Override
    @Transactional
    public Address save(Address address){
        return addressRepository.save(address);
    }
}
