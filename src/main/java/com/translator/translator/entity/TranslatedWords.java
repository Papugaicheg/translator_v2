package com.translator.translator.entity;


import jakarta.persistence.*;

@Entity

public class TranslatedWords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String word;
    String translatedWord;

    @ManyToOne(targetEntity = RequestEntity.class, fetch = FetchType.LAZY)
    RequestEntity requestID;

}
