package com.amaristest.amaristest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AmaristestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmaristestApplication.class, args);
	}

}
