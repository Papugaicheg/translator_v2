package com.translator.translator.dto.mapper;


import com.translator.translator.dto.ResponseDTO;
import com.translator.translator.dto.ResponseYandexDTO;

public interface ResponseMapper {
    ResponseDTO toDTOFromYandex(ResponseYandexDTO responseYandexDTO);
}
