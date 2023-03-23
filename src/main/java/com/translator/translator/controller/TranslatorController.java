package com.translator.translator.controller;

import com.translator.translator.dto.RequestDTO;
import com.translator.translator.dto.ResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TranslatorController {

    @PostMapping("/translate")
    public ResponseEntity<ResponseDTO> getTranslation(@RequestBody RequestDTO requestDTO, HttpServletRequest request){
        return null;
    }

}
