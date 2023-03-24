package com.translator.translator.service;

import com.translator.translator.controller.TranslatorController;
import com.translator.translator.dto.RequestYandexDTO;
import com.translator.translator.dto.ResponseYandexDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
    private final Logger logger = LoggerFactory.getLogger(TranslatorController.class);
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
            logger.error("RestClientException during the execution of the request");
            return null;
        }

    }
}
