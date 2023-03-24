package com.translator.translator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestYandexDTO {
    String sourceLanguageCode;
    String targetLanguageCode;
    List<String> texts = new ArrayList<>();

}
