package com.translator.translator.dto.mapper;

import com.translator.translator.dto.RequestDTO;
import com.translator.translator.dto.yandexAPI.RequestToYandexDTO;

public interface RequestMapper {
    RequestToYandexDTO toYandexRequest(RequestDTO requestDTO);

}
