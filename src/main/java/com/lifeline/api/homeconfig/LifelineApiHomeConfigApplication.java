package com.lifeline.api.homeconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LifelineApiHomeConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(LifelineApiHomeConfigApplication.class, args);
	}

}