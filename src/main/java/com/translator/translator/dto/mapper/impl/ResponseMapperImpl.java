package com.translator.translator.dto.mapper.impl;

import com.translator.translator.dto.ResponseDTO;
import com.translator.translator.dto.ResponseYandexDTO;
import com.translator.translator.dto.mapper.ResponseMapper;

public class ResponseMapperImpl implements ResponseMapper {
    @Override
    public ResponseDTO toDTOFromYandex(ResponseYandexDTO responseYandexDTO) {

        StringBuilder builder = new StringBuilder();
        responseYandexDTO.getTranslations().forEach(c->builder.append(c.get("text")).append(" "));

        return new ResponseDTO(builder.toString().trim());
    }





}
