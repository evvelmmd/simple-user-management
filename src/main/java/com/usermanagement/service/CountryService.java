package com.usermanagement.service;

import com.usermanagement.entity.CityEntity;
import com.usermanagement.entity.CountryDTO;
import com.usermanagement.entity.CountryEntity;

import java.util.List;

public interface CountryService {
    void addCountry(String countryName);

    void addCity(String cityName, Integer countryId);

    List<CountryDTO> getAllCountries();

    void updateCountry(int countryId, String newName);

    void deleteCountry(int countyId);

    void deleteCity(int cityId);

    void updateCity(int cityId,String newName);

    List<CityEntity> getCitiesByCountry(Integer countryId);
}
