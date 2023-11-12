package com.iitmsc.developeriq.external.api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * Base class for all API connectors
 */
public abstract class ApiConnector {

    protected RestTemplate restTemplate;

    protected String authToken;

    /**
     * Call API with Get method
     * @param url
     * @return
     */
    public List<Map<String, Object>>   callGetApi(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>( headers);
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Map<String, Object>>>() {}
        );

        return response.getBody();
    }
}
