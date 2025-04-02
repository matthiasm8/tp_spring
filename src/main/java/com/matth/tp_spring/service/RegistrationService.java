package com.matth.tp_spring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import java.util.HashMap;
import java.util.Map;

@Service
public class RegistrationService {

    private static final String SERVER_ARENA_URL = "http://51.210.251.137/arena/register";
    private static final String BASE_URL = "http://localhost:8080/";

    private final RestTemplate restTemplate;

    public RegistrationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void registerToArena() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("studentName", "Matthias");
        requestBody.put("baseUrl", BASE_URL);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(SERVER_ARENA_URL, request, String.class);
            System.out.println("Inscription réussie : " + response.getBody());
        } catch (Exception e) {
            System.err.println("Erreur lors de l'inscription à l'Arène : " + e.getMessage());
        }
    }
}
