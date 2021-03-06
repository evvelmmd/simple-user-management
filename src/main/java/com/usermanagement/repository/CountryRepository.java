package com.usermanagement.repository;

import com.usermanagement.entity.CountryEntity;
import com.usermanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
    CountryEntity getCountryEntitiesByName(String name);
}