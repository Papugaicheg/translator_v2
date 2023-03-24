package com.translator.translator.service;

import com.translator.translator.dto.RequestYandexDTO;
import com.translator.translator.dto.ResponseYandexDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestService {

    @Value("${url}")
    private String url;
    @Value("${Api-Key}")
    private String apiKey;
    private final RestTemplate restTemplate;

    public ResponseYandexDTO getTranslate(RequestYandexDTO requestYandexDTO) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", String.format("Api-Key %s", apiKey));

        HttpEntity request = new HttpEntity(requestYandexDTO, headers);

        try {
            return restTemplate.exchange(url, HttpMethod.POST, request, ResponseYandexDTO.class).getBody();
        } catch (RestClientException e) {
            log.error("RestClientException during the execution of the request");
            return null;
        }

    }
}
