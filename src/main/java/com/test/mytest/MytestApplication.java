package com.test.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EntityScan("com.test.mytest.entity")
public class MytestApplication {
	public static void main(String[] args) {
		SpringApplication.run(MytestApplication.class, args);
	}
}
