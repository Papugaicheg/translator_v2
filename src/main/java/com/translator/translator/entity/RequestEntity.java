package com.translator.translator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String inputData;
    String outputData;

    Timestamp dateTime;
    String parameters;
    String ipAdress;
}
