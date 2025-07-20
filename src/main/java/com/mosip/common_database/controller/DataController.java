package com.mosip.common_database.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mosip.common_database.service.repository.RepositoryService;
import com.mosip.common_database.service.validation.ValidationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class DataController {

    private final Map<String, ValidationService> validationServices;
    private final Map<String, RepositoryService> repositoryServices;

    @GetMapping("/api/data/retrieve/{id}")
    public String retrieveDataById(String id) {
        return "hello";
    }

    @GetMapping("/api/data/query")
    public String retrieveDataByQuery(String id) {
        return "hello";
    }

    @PostMapping("/api/data/ingest")
    public ResponseEntity<?> ingestData(
        @RequestHeader(name = "x-source") String dataSource,
        @RequestBody Map<String, Object> data) 
    {
        ValidationService validationService = validationServices.get(dataSource + "ValidationService");
        RepositoryService repositoryService = repositoryServices.get(dataSource + "RepositoryService");
        
        if(validationService == null){
            return ResponseEntity.badRequest().body("Unknown data source: " + dataSource);
        }

        validationService.validate(data);
        repositoryService.save(data);
        return ResponseEntity.ok().build();
    }

}
