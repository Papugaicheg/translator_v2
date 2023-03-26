package com.translator.translator.service;

import com.translator.translator.entity.SentRequestEntity;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Service
@AllArgsConstructor
public class SentRequestService {


    private final TranslatedWordsService translatedWordsService;
    private final JdbcTemplate jdbcTemplate;


    @Transactional(rollbackFor = RuntimeException.class)
    public void save(SentRequestEntity requestEntity) throws DataAccessException {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement("INSERT INTO request(input_Data,output_Data,date_Time,parameters,ip_Address) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

                    ps.setString(1, requestEntity.getInputData());
                    ps.setString(2, requestEntity.getOutputData());
                    ps.setString(3, requestEntity.getDateTime().toString());
                    ps.setString(4, requestEntity.getParameters());
                    ps.setString(5, requestEntity.getIpAddress());
                    return ps;
                },
                keyHolder);

        if (keyHolder.getKey() != null) {
            Long requestId = keyHolder.getKey().longValue();
            translatedWordsService.save(requestEntity, requestId);
        } else {
            throw new DataAccessException("Something is wrong with inserting the request") {
            };
        }

    }
}
