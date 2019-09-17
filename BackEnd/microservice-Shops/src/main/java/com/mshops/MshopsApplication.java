package com.mshops;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MshopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MshopsApplication.class, args);
	}

	
}
