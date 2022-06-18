package com.sevinc.intership_management_system.repository;

import com.sevinc.intership_management_system.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
