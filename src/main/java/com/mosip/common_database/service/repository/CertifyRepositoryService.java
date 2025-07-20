package com.mosip.common_database.service.repository;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.mosip.common_database.dto.certify.CertifyDto;
import com.mosip.common_database.entity.certify.CertifyEntity;
import com.mosip.common_database.mapper.certify.CertifyMapper;
import com.mosip.common_database.repository.certify.CertifyRepository;

import lombok.AllArgsConstructor;

@Service("certifyRepositoryService")
@AllArgsConstructor
public class CertifyRepositoryService implements RepositoryService {

    private final CertifyRepository certifyRepository;
    private final CertifyMapper certifyMapper;

    @Override
    public Map<String, Object> save(Map<String, Object> certifyObject) {

        CertifyDto certifyDto = certifyMapper.toDto(certifyObject);
        CertifyEntity certifyEntity = certifyMapper.toEntity(certifyDto);

        certifyRepository.save(certifyEntity);

        return certifyMapper.toMap(certifyDto);

    }

}
