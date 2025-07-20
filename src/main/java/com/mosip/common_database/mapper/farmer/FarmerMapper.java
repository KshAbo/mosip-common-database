package com.mosip.common_database.mapper.farmer;

import java.util.HashMap;
import java.util.Map;

import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;

import com.mosip.common_database.dto.farmer.FarmerDto;
import com.mosip.common_database.entity.farmer.FarmerEntity;
import com.mosip.common_database.mapper.MappingUtils;

@Mapper(componentModel = "spring", uses = MappingUtils.class)
public interface FarmerMapper {

    FarmerDto toDto(Map<String, Object> farmerMapObject);

    FarmerEntity toEntity(FarmerDto farmerDto);

    Map<String, Object> toMap(FarmerDto farmerDto);

    @ObjectFactory
    default Map<String, Object> createMap() {
        return new HashMap<>();
    }
}
