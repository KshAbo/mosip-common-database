package com.mosip.common_database.service.repository;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.mosip.common_database.dto.farmer.FarmerDto;
import com.mosip.common_database.entity.farmer.FarmerEntity;
import com.mosip.common_database.mapper.farmer.FarmerMapper;
import com.mosip.common_database.repository.farmer.FarmerRepository;

import lombok.AllArgsConstructor;

@Service("farmerRepositoryService")
@AllArgsConstructor
public class FarmerRepositoryService implements RepositoryService {

    private final FarmerRepository farmerRepository;
    private final FarmerMapper farmerMapper;

    @Override
    public Map<String, Object> save(Map<String, Object> farmerObject) {
        FarmerDto farmerDto = farmerMapper.toDto(farmerObject);
        FarmerEntity farmerEntity = farmerMapper.toEntity(farmerDto);

        farmerRepository.save(farmerEntity);

        return farmerMapper.toMap(farmerDto);
    }

}
