package com.colak.springfeignclienttutorial.apigateway.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Run on default port 8080
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ApiGatewayControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    // Gather Quotes from Service
    @Test
    void testGather() {
        String getUrl = "http://localhost:8080/api/gateway/getQuote/1";

        // Create HttpHeaders object to hold the headers
        HttpHeaders headers = new HttpHeaders();

        // Set the Content-Type header to application/json
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Add custom headers with custom values
        headers.set("Authorization", "Bearer your_access_token");

        // Create a HttpEntity with the headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
        String message = response.getBody();
        assert message != null;

        assertEquals("Quote : 1", message);
    }

}
