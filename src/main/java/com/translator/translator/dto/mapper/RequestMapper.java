package com.translator.translator.dto.mapper;

import com.translator.translator.dto.RequestDTO;
import com.translator.translator.dto.RequestToYandexDTO;

public interface RequestMapper {
    public RequestToYandexDTO toYandexRequest(RequestDTO requestDTO);

}
