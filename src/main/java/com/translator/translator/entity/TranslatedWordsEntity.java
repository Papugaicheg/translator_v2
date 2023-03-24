package com.translator.translator.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "translatedWords")
public class TranslatedWordsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String word;
    String translatedWord;

    @ManyToOne(targetEntity = SentRequestEntity.class, fetch = FetchType.LAZY)
    SentRequestEntity requestID;

}
