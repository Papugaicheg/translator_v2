package com.translator.translator.dto.mapper;


import com.translator.translator.dto.ResponseDTO;
import com.translator.translator.dto.ResponseYandexDTO;
import com.translator.translator.entity.SentRequestEntity;

public interface ResponseMapper {
    public ResponseDTO toDTOFromEntity(SentRequestEntity sentRequestEntity);
    public ResponseDTO toDTOFromYandex(ResponseYandexDTO responseYandexDTO);
}
