package com.example.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EmployeeEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeEurekaServerApplication.class, args);
	}

}
