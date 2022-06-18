package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.dto.AddressResponseDTO;
import com.sevinc.intership_management_system.dto.AddressSaveDTO;
import com.sevinc.intership_management_system.dto.AddressSaveFullIdDTO;
import com.sevinc.intership_management_system.dto.AddressSaveIdDTO;
import com.sevinc.intership_management_system.model.Address;

import java.util.List;

public interface AddressService {
    AddressResponseDTO saveAddress(AddressSaveDTO addressSaveDto);

    AddressResponseDTO saveAddress(AddressSaveIdDTO addressSaveIdDto);

    List<AddressResponseDTO> getAllAddress();

    AddressResponseDTO getByAddressResponseDtoId(Long addressId);

    Address getByAddressId(Long addressId);

    AddressResponseDTO saveAddress(AddressSaveFullIdDTO addressSaveFullIdDTO);

    Address save(Address address);
}
