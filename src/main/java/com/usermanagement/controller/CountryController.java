package com.usermanagement.controller;

import com.usermanagement.entity.CityEntity;
import com.usermanagement.entity.CountryDTO;
import com.usermanagement.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryDTO> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/cities/{countryId}")
    public List<CityEntity> getAllCities(@PathVariable Integer countryId) {
        return countryService.getCitiesByCountry(countryId);
    }

    @PostMapping("/{countryName}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCountry(@PathVariable String countryName) {
        countryService.addCountry(countryName);
    }

    @PostMapping("/city/{countryId}/{cityName}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCity(@PathVariable("cityName") String cityName, @PathVariable("countryId") Integer countryId) {
        countryService.addCity(cityName, countryId);
    }

    @PutMapping("/{countryId}")
    public void updateCountry(@PathVariable("countryId") int countryId, @RequestParam String newName) {
        countryService.updateCountry(countryId, newName);
    }

    @PutMapping("/city/{cityId}")
    public void updateCity(@PathVariable("cityId") int cityId, @RequestParam String newName) {
        countryService.updateCity(cityId, newName);
    }

    @DeleteMapping("/{countryId}")
    public void deleteCountry(@PathVariable int countryId) {
        countryService.deleteCountry(countryId);
    }

    @DeleteMapping("/city/{cityId}")
    public void deleteCity(@PathVariable int cityId) {
        countryService.deleteCity(cityId);
    }
}
