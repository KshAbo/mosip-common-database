package com.mosip.common_database.service;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component("certify")
public class CertifyValidationService implements ValidationService{

    @Override
    public void validate(Map<String, Object> data){
        System.out.println("Verifying by Certify");
    }

}
