package com.translator.translator.service;


import com.translator.translator.controller.TranslatorController;
import com.translator.translator.dto.RequestDTO;
import com.translator.translator.dto.RequestYandexDTO;
import com.translator.translator.dto.ResponseDTO;
import com.translator.translator.dto.ResponseYandexDTO;
import com.translator.translator.dto.mapper.impl.RequestMapperImpl;
import com.translator.translator.dto.mapper.impl.ResponseMapperImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TranslateService {

    private final Logger logger = LoggerFactory.getLogger(TranslatorController.class);
    private final RestService restService;
    private final RequestService requestService;

    public ResponseDTO translate(RequestDTO requestDTO){

        logger.info("Start conversation RequestDTO into RequestYandexDTO ");
        RequestYandexDTO requestToYandex = new RequestMapperImpl().toYandexRequest(requestDTO);

        logger.info("Sending a request to YandexAPI");
        ResponseYandexDTO responseYandexDTO = restService.getTranslate(requestToYandex);
        if(responseYandexDTO == null){
            logger.error("Something is wrong with request to YandexAPI");
            return null;
        }

        logger.info("Start conversation ResponseYandexDTO into ResponseDTO");
        ResponseDTO responseDTO = new ResponseMapperImpl().toDTOFromYandex(responseYandexDTO);

        try {

            logger.info("Start inserting into DB");
            System.out.println(requestDTO);
            System.out.println(responseDTO);
            requestService.save(requestDTO, responseDTO);

            logger.info("Success!");

        }catch (DataAccessException e){
            logger.error("Something is wrong with inserting into DB");
            return null;
        }

        return responseDTO;
    }





}
