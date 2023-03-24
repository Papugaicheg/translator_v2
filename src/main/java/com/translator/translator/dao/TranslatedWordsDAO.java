package com.translator.translator.dao;


import com.translator.translator.entity.SentRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TranslatedWordsDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TranslatedWordsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void save(SentRequestEntity requestEntity, Long requestId) throws DataAccessException {
        String[] listOfTranslatedWords = requestEntity.getOutputData().split(" ");
        String[] listOfWords = requestEntity.getInputData().split(" ");

        for (int i = 0; i < listOfWords.length; i++) {
            jdbcTemplate.update("INSERT INTO translated_Words(word,translated_word,request_id) VALUES (?, ?, ?)", listOfWords[i], listOfTranslatedWords[i], requestId);
        }

    }
}
