package com.translator.translator.service;

import com.translator.translator.db.dao.RequestDAO;
import com.translator.translator.dto.RequestDTO;
import com.translator.translator.dto.RequestYandexDTO;
import com.translator.translator.dto.ResponseDTO;
import com.translator.translator.entity.SentRequestEntity;
import com.translator.translator.repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@AllArgsConstructor
public class RequestService {

    @Autowired
    private RequestDAO requestDAO;

    private final RequestRepository requestRepository;

    public void save(RequestDTO requestDTO, ResponseDTO responseDTO) {
        SentRequestEntity request = SentRequestEntity.builder()
                .inputData(requestDTO.getInputString())
                .parameters(requestDTO.getTranslateParameters())
                .dateTime(new Timestamp(new Date().getTime()))
                .ipAddress(requestDTO.getRequest().getRemoteAddr())
                .outputData(responseDTO.getTranslatedText())
                .build();
        requestDAO.save(request);
    }
}
