package com.translator.translator.repository;

import com.translator.translator.entity.SentRequestEntity;
import com.translator.translator.entity.TranslatedWordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslatedWordsRepository extends JpaRepository<TranslatedWordsEntity, Long> {
}
