package com.translator.translator.dto;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {
    private String inputString;
    private String translateParameters;
    private HttpServletRequest request;
}
