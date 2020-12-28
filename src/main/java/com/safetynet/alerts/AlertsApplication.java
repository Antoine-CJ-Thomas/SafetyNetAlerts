package com.safetynet.alerts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safetynet.alerts.service.LaunchService;

@SpringBootApplication
public class AlertsApplication {

	public static void main(String[] args) {

		SpringApplication.run(AlertsApplication.class, args);
		
		LaunchService launchService = new LaunchService();
	}
}