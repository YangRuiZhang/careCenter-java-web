package com.seu.care.bed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BedApplication {

	public static void main(String[] args) {
		SpringApplication.run(BedApplication.class, args);
	}

}
