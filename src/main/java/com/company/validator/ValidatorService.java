package com.company.validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ValidatorService {

    public static void main(String[] args) {
        SpringApplication.run(ValidatorService.class, args);
    }

}
