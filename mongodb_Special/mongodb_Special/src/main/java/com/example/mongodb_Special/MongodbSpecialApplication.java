package com.example.mongodb_Special;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MongodbSpecialApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbSpecialApplication.class, args);
	}

}
