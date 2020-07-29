package com.example.PhotoAppUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppUserApplication {


    //To run multiple instance of application. Run...>Run...>edit configuration

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppUserApplication.class, args);
	}

}
