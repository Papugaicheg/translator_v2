package com.translator.translator.repository;

import com.translator.translator.entity.SentRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository  extends JpaRepository<SentRequestEntity, Long> {

}
