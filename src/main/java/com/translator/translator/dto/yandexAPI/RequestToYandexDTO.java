package com.translator.translator.dto.yandexAPI;

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
public class RequestToYandexDTO {
    String sourceLanguageCode;
    String targetLanguageCode;

    List<String> texts = new ArrayList<>();

}
