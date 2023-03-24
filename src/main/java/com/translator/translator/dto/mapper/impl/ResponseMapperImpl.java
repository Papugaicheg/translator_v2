package com.translator.translator.dto.mapper.impl;

import com.translator.translator.dto.ResponseDTO;
import com.translator.translator.dto.ResponseYandexDTO;
import com.translator.translator.dto.mapper.ResponseMapper;
import com.translator.translator.entity.SentRequestEntity;

public class ResponseMapperImpl implements ResponseMapper {

    @Override
    public ResponseDTO toDTOFromEntity(SentRequestEntity sentRequestEntity) {
        return new ResponseDTO(sentRequestEntity.getOutputData());
    }

    @Override
    public ResponseDTO toDTOFromYandex(ResponseYandexDTO responseYandexDTO) {
        StringBuilder builder = new StringBuilder();
        responseYandexDTO.getTranslations().forEach(c->builder.append(c.get("text")).append(" "));
        return new ResponseDTO(builder.toString());
    }





}
