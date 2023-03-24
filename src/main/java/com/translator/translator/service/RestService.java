package com.translator.translator.service;

import com.translator.translator.dto.RequestYandexDTO;
import com.translator.translator.dto.ResponseYandexDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestService {

    @Value("${url}")
    String url;
    @Value("${Api-Key}")
    String apiKey;
    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseYandexDTO getTranslate(RequestYandexDTO requestYandexDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",String.format("Api-Key %s",apiKey));
        HttpEntity request = new HttpEntity(requestYandexDTO, headers);
        try{
            return restTemplate.exchange(url, HttpMethod.POST,request,ResponseYandexDTO.class).getBody();
        }catch (RestClientException e){
            System.out.println("Error");
            return null;
        }

    }
}
