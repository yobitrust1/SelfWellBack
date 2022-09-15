package com.yobitrust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CognitivelyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CognitivelyServiceApplication.class, args);
	}

}
