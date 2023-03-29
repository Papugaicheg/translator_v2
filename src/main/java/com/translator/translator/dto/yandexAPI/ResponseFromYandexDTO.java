package com.translator.translator.dto.yandexAPI;


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
    private List<Map<String, String>> translations = new ArrayList<>();
}
