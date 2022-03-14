package com.usermanagement.mapper;

import com.usermanagement.entity.CityEntity;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Mapping( target = "country", ignore = true)
    CityEntity toDtoWithoutCountry(CityEntity cities);

    List<CityEntity> toDtoWithoutCountry(List<CityEntity> cities);
}
