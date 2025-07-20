package com.mosip.common_database.service.repository;


import java.util.Map;

public interface RepositoryService {

    public Map<String, Object> save(Map<String, Object> obj);

    // Optional<Map<String, Object>> getById(Long id);

    // void deleteById(Long id);

}
