package com.usermanagement.controller;

import com.usermanagement.entity.CountryDTO;
import com.usermanagement.entity.CountryEntity;
import com.usermanagement.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryDTO> getAllCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping("/{countryName}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCountry(@PathVariable String countryName) {
        countryService.addCountry(countryName);
    }

    @PostMapping("/city/{countryName}/{cityName}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCity(@PathVariable("cityName") String cityName, @PathVariable("countryName") String countryName) {
        countryService.addCity(cityName, countryName);
    }

    @PutMapping("/{countryName}")
    public void updateCountry(@PathVariable("countryName") int countryId, @RequestParam String newName) {
        countryService.updateCountry(countryId, newName);
    }

    @DeleteMapping ("/{countryId}")
    public void deleteCountry(@PathVariable int countryId) {
        countryService.deleteCountry(countryId);
    }
}
