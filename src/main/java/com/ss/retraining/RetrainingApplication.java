package com.ss.retraining;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EntityScan
@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class RetrainingApplication {
    public static void main(String[] args) {
        SpringApplication.run(RetrainingApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}

