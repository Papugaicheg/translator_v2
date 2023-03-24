package com.translator.translator.service;

import com.translator.translator.repository.TranslatedWordsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TranslatedWordsService {

    private final TranslatedWordsRepository translatedWordsRepository;



}
