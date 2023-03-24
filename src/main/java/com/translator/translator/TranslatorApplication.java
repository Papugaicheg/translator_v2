package com.translator.translator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TranslatorApplication {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TranslatorApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TranslatorApplication.class, args);
	}

}
