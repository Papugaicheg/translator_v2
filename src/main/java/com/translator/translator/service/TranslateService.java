package com.translator.translator.service;


import com.translator.translator.dto.RequestDTO;
import com.translator.translator.dto.RequestToYandexDTO;
import com.translator.translator.dto.ResponseDTO;
import com.translator.translator.dto.ResponseFromYandexDTO;
import com.translator.translator.dto.mapper.impl.RequestMapperImpl;
import com.translator.translator.dto.mapper.impl.ResponseMapperImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class TranslateService {

    private final RestService restService;
    private final RequestService requestService;

    public ResponseDTO translate(RequestDTO requestDTO) {

        log.info("Start conversation RequestDTO into RequestYandexDTO ");
        RequestToYandexDTO requestToYandex = new RequestMapperImpl().toYandexRequest(requestDTO);

        log.info("Sending a request to YandexAPI");
        ResponseFromYandexDTO responseFromYandexDTO = restService.getTranslate(requestToYandex);
        if (responseFromYandexDTO == null) {
            log.error("Something is wrong with request to YandexAPI");
            return null;
        }

        log.info("Start conversation ResponseYandexDTO into ResponseDTO");
        ResponseDTO responseDTO = new ResponseMapperImpl().toDTOFromYandex(responseFromYandexDTO);

        try {

            log.info("Start inserting into DB");
            requestService.save(requestDTO, responseDTO);

            log.info("Success!");

        } catch (DataAccessException e) {
            log.error("DataAccessException | Something is wrong with inserting into DB ");
            return null;
        }

        return responseDTO;
    }


}
