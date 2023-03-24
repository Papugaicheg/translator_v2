package com.translator.translator.dto.mapper.impl;

import com.translator.translator.dto.RequestDTO;
import com.translator.translator.dto.RequestYandexDTO;
import com.translator.translator.dto.mapper.RequestMapper;

import java.util.List;

public class RequestMapperImpl implements RequestMapper {
    @Override
    public RequestYandexDTO toYandexRequest(RequestDTO requestDTO) {
        return RequestYandexDTO.builder()
                .sourceLanguageCode(requestDTO.getTranslateParameters().split("-")[0])
                .targetLanguageCode(requestDTO.getTranslateParameters().split("-")[1])
                .texts(List.of(requestDTO.getInputString().split(" ")))
                .build();
    }
}
