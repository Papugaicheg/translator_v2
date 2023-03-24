package com.translator.translator.controller;

import com.translator.translator.dto.RequestDTO;
import com.translator.translator.dto.ResponseDTO;
import com.translator.translator.service.TranslateService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor

public class TranslatorController {
    private final Logger logger = LoggerFactory.getLogger(TranslatorController.class);
    private final TranslateService translateService;


    @PostMapping(value = "/translate",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> getTranslation(@RequestBody RequestDTO requestDTO, HttpServletRequest request){

        logger.info("Request received");
        requestDTO.setRequest(request);

        logger.info("The request has been sent to TranslateService for processing");
        ResponseDTO responseDTO = translateService.translate(requestDTO);

        if(responseDTO == null){
            logger.error("Oops! Translate Service returned null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        logger.info("Request completed successfully");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
