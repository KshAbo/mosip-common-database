package com.mosip.common_database.service;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public interface ValidationService {

    public void validate(Map<String, Object> data);
}
