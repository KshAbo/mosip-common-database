package com.mosip.common_database.service.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {

    private String filterKey;
    private Object value;
    private String operation;
    private String dataOption;

    public SearchCriteria(String filterKey, String operation, 
                          Object value){
        this.filterKey = filterKey;
        this.operation = operation;
        this.value = value;
    }
}