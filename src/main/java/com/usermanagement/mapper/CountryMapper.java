package com.usermanagement.mapper;

import com.usermanagement.entity.CityEntity;
import com.usermanagement.entity.CountryDTO;
import com.usermanagement.entity.CountryEntity;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = CityMapper.class)
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "cities", source = "cities"),
    })
    CountryDTO entityToDTO(CountryEntity countryEntity);

    List<CountryDTO> entityToDtoList(List<CountryEntity> entities);
}
