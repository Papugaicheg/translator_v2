package com.translator.translator.service;


import com.translator.translator.entity.SentRequestEntity;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class TranslatedWordsService {

    private final JdbcTemplate jdbcTemplate;


    @Transactional(rollbackFor = RuntimeException.class)
    public void save(SentRequestEntity requestEntity, Long requestId) throws DataAccessException {
        List<String> listOfTranslatedWords = List.of(requestEntity.getOutputData().split(" "));
        List<String> listOfWords = List.of(requestEntity.getInputData().split(" "));
        IntStream.range(0, listOfWords.size()).forEach(i -> jdbcTemplate.update("INSERT INTO translated_Words(word,translated_word,request_id) VALUES (?, ?, ?)",
                listOfWords.get(i), listOfTranslatedWords.get(i), requestId));


    }
}
