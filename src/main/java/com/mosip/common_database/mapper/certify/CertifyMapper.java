package com.mosip.common_database.mapper.certify;

import java.util.HashMap;
import java.util.Map;

import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;

import com.mosip.common_database.dto.certify.CertifyDto;
import com.mosip.common_database.entity.certify.CertifyEntity;
import com.mosip.common_database.mapper.MappingUtils;

@Mapper(componentModel = "spring", uses = MappingUtils.class)
public interface CertifyMapper {

    CertifyDto toDto(Map<String, Object> certifyMapObject);

    CertifyEntity toEntity(CertifyDto certifyDto);

    Map<String, Object> toMap(CertifyDto certifyDto);


    @ObjectFactory
    default Map<String, Object> createMap() {
        return new HashMap<>();
    }

}
