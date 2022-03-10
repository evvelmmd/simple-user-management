package com.usermanagement.service.impl;

import com.usermanagement.entity.CityEntity;
import com.usermanagement.entity.CountryDTO;
import com.usermanagement.entity.CountryEntity;
import com.usermanagement.mapper.CountryMapper;
import com.usermanagement.repository.CityRepository;
import com.usermanagement.repository.CountryRepository;
import com.usermanagement.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    @Override
    public void addCountry(String countryName) {
        CountryEntity countryEntity = CountryEntity.builder().name(countryName).build();

        countryRepository.save(countryEntity);

    }

    @Override
    public void addCity(String cityName, String countryName) {
        CountryEntity countryEntity = countryRepository.getCountryEntitiesByName(countryName);
        CityEntity cityEntity = CityEntity.builder().name(cityName).country(countryEntity).build();

        cityRepository.save(cityEntity);
    }

    @Override
    public List<CountryDTO> getAllCountries() {
        return CountryMapper.INSTANCE.entityToDtoList(countryRepository.findAll());
    }

    @Override
    public void updateCountry(int countryId, String newName) {
        CountryEntity countryEntity = countryRepository.getById(countryId);
        countryEntity.setName(newName);
        countryRepository.save(countryEntity);
    }

    @Override
    public void deleteCountry(int countryId) {
        CountryEntity countryEntity = countryRepository.getById(countryId);
        countryRepository.delete(countryEntity);
    }
}
