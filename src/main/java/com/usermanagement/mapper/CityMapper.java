package com.usermanagement.mapper;

import com.usermanagement.entity.CityEntity;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityMapper {

    @Mapping( target = "country", ignore = true)
    CityEntity toDtoWithoutCountry(CityEntity cities);

    List<CityEntity> toDtoWithoutCountry(List<CityEntity> cities);
}
