package com.translator.translator.db.dao;

import com.translator.translator.entity.SentRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class RequestDAO {

    @Autowired
    private final TranslatedWordsDAO translatedWordsDAO;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RequestDAO(TranslatedWordsDAO translatedWordsDAO, JdbcTemplate jdbcTemplate) {
        this.translatedWordsDAO = translatedWordsDAO;
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save(SentRequestEntity requestEntity){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement("INSERT INTO request(id,inputData,outputData,dateTime,parameters,ipAddress) VALUES (1, ?, ?, ?, ?, ?)");

                    ps.setString(1,requestEntity.getInputData());
                    ps.setString(2,requestEntity.getOutputData());
                    ps.setString(3,requestEntity.getDateTime().toString());
                    ps.setString(4,requestEntity.getParameters());
                    ps.setString(5,requestEntity.getIpAddress());
                    return ps;
                },
                keyHolder);
        Long requestId = keyHolder.getKey().longValue();
        translatedWordsDAO.save(requestEntity, requestId);
    }
}
