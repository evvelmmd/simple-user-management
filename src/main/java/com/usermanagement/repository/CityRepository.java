package com.usermanagement.repository;

import com.usermanagement.entity.CityEntity;
import com.usermanagement.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    List<CityEntity> getAllCitiesByCountryId(Integer countryId);
}
