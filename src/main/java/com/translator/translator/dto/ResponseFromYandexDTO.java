package com.translator.translator.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseFromYandexDTO {
    List<Map<String, String>> translations = new ArrayList<>();
}
