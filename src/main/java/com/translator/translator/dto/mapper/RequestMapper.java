package com.translator.translator.dto.mapper;

import com.translator.translator.dto.RequestDTO;
import com.translator.translator.dto.RequestYandexDTO;

public interface RequestMapper {
    public RequestYandexDTO toYandexRequest(RequestDTO requestDTO);

}
