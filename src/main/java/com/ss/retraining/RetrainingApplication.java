package com.ss.retraining;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@EntityScan
@SpringBootApplication
public class RetrainingApplication {
    public static void main(String[] args) {

        SpringApplication.run(RetrainingApplication.class, args);

    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}

