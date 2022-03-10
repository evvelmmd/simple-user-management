package com.usermanagement.service;

import com.usermanagement.entity.CountryDTO;
import com.usermanagement.entity.CountryEntity;

import java.util.List;

public interface CountryService {
    void addCountry(String countryName);

    void addCity(String cityName, String countryName);

    List<CountryDTO> getAllCountries();

    void updateCountry(int countryId, String newName);

    void deleteCountry(int countyId);
}
