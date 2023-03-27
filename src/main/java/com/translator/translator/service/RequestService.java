package com.translator.translator.service;

import com.translator.translator.dto.RequestDTO;
import com.translator.translator.dto.ResponseDTO;
import com.translator.translator.entity.SentRequestEntity;
import com.translator.translator.service.jdbc.SentRequestService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@AllArgsConstructor
public class RequestService {
    private SentRequestService sentRequestService;

    public void save(RequestDTO requestDTO, ResponseDTO responseDTO) throws DataAccessException {
        SentRequestEntity request = SentRequestEntity.builder()
                .inputData(requestDTO.getInputString())
                .parameters(requestDTO.getTranslateParameters())
                .dateTime(new Timestamp(new Date().getTime()))
                .ipAddress(requestDTO.getRequest().getRemoteAddr())
                .outputData(responseDTO.getTranslatedText())
                .build();
        sentRequestService.save(request);
    }
}
