package com.translator.translator.dto.mapper;


import com.translator.translator.dto.ResponseDTO;
import com.translator.translator.dto.ResponseFromYandexDTO;

public interface ResponseMapper {
    ResponseDTO toDTOFromYandex(ResponseFromYandexDTO responseFromYandexDTO);
}
