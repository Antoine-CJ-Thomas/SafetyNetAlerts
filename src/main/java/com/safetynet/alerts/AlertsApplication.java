package com.safetynet.alerts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safetynet.alerts.service.LaunchingService;

@SpringBootApplication
public class AlertsApplication {
	
	private static LaunchingService launchingService = new LaunchingService();;

	public static void main(String[] args) {

		SpringApplication.run(AlertsApplication.class, args);
		
		launchingService.LaunchApplication();
	}
}