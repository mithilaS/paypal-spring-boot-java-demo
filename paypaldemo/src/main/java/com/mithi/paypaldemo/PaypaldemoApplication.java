package com.mithi.paypaldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class PaypaldemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(PaypaldemoApplication.class, args);

	}

}
