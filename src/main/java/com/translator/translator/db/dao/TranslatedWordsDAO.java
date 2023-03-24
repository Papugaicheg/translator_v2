package com.translator.translator.db.dao;


import com.translator.translator.entity.SentRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TranslatedWordsDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TranslatedWordsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save(SentRequestEntity requestEntity, Long requestId) {
        String[] listOfTranslatedWords = requestEntity.getOutputData().split(" ");
        String[] listOfWords = requestEntity.getInputData().split(" ");


        for (int i = 0; i < listOfWords.length; i++) {
            jdbcTemplate.update("INSERT INTO translatedWords VALUES (1, ?, ?, ?)", listOfWords[i], listOfTranslatedWords[i], requestEntity.getId());
        }

    }
}
