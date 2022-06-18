package com.sevinc.intership_management_system.repository;

import com.sevinc.intership_management_system.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findCityByCityId(Long cityId);
    Optional<City> findCityByCityKey(Long cityKey);
}
