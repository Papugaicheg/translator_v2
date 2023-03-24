package com.translator.translator.service;


import com.translator.translator.dto.RequestDTO;
import com.translator.translator.dto.RequestYandexDTO;
import com.translator.translator.dto.ResponseDTO;
import com.translator.translator.dto.ResponseYandexDTO;
import com.translator.translator.dto.mapper.ResponseMapper;
import com.translator.translator.dto.mapper.impl.RequestMapperImpl;
import com.translator.translator.dto.mapper.impl.ResponseMapperImpl;
import com.translator.translator.entity.SentRequestEntity;
import com.translator.translator.entity.TranslatedWordsEntity;
import com.translator.translator.repository.RequestRepository;
import com.translator.translator.repository.TranslatedWordsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@AllArgsConstructor
public class TranslateService {


    private final RestService restService;
    private final RequestService requestService;
    private final TranslatedWordsService translatedWordsService;

    public ResponseDTO translate(RequestDTO requestDTO){
        RequestYandexDTO requestToYandex = new RequestMapperImpl().toYandexRequest(requestDTO);

        ResponseYandexDTO responseYandexDTO = restService.getTranslate(requestToYandex);

        ResponseDTO responseDTO = new ResponseMapperImpl().toDTOFromYandex(responseYandexDTO);
        requestService.save(requestDTO, responseDTO);





        return responseDTO;
    }





}
