package com.mosip.common_database.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Component("certify")
public class CertifyValidationService implements ValidationService{

    private Set<String> requiredFields;
    private Map<String, Pattern> fieldRegex;

    private Map<String, Object> readConfig(InputStream in) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(in, new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException e) {
            System.out.println("Given file is empty or invalid");
            return Collections.emptyMap();
        }
    }

    @PostConstruct
    private void loadConfig() {
        
        try {

            InputStream in = getClass().getClassLoader().getResourceAsStream("validation/certify.json");
            if (in == null) {
                throw new RuntimeException("Config file not found: validation/certify.json");
            }
            Map<String, Object> config = readConfig(in);

            requiredFields = new HashSet<>((List<String>) config.get("required"));

            fieldRegex = new HashMap<>();
            Map<String, String> patterns = (Map<String, String>) config.get("regex");
            for(Map.Entry<String, String> entry : patterns.entrySet()){
                fieldRegex.put(entry.getKey(), Pattern.compile(entry.getValue()));
            }
        } catch (Exception e) {
            System.out.println("ERROR: Given file is empty or invalid");
            throw new RuntimeException("Failed to load config for CertifyValidationService", e);
        }

    }

    @Override
    public void validate(Map<String, Object> data){

        for(String field : requiredFields){
            if(!data.containsKey(field)){
                throw new IllegalArgumentException("Missing required field: " + field);
            }
        }

        for(Map.Entry<String, Pattern> entry : fieldRegex.entrySet()) {
            Object value = data.get(entry.getKey());
            if (value != null && !entry.getValue().matcher(value.toString()).matches()) {
                throw new IllegalArgumentException("Field '" + entry.getKey() + "' does not match pattern");
            }
        }

        System.out.println("CertifyValidationService: Validation Passed!");
    }

}
