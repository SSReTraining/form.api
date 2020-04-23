package com.ss.retraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class RetrainingApplication {


	public static void main(String[] args) {
		SpringApplication.run(RetrainingApplication.class, args);
	}


}

