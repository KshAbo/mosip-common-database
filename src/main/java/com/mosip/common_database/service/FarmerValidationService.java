package com.mosip.common_database.service;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component("farmer")
public class FarmerValidationService implements ValidationService{

    @Override
    public void validate(Map<String, Object> data) {
        System.out.println("Verifying by Farmer");
    }
    
}
