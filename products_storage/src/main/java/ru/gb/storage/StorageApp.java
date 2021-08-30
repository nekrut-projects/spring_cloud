package ru.gb.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StorageApp {
	public static void main(String[] args) {
		SpringApplication.run(StorageApp.class, args);
	}
}

