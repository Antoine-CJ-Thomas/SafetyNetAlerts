package com.safetynet.alerts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safetynet.alerts.service.LaunchingService;

/**
 * This class allow to start the application
 */
@SpringBootApplication
public class AlertsApplication {

    private static final Logger logger = LogManager.getLogger("AlertsApplication");
	private static LaunchingService launchingService = new LaunchingService();;

	public static void main(String[] args) {

		SpringApplication.run(AlertsApplication.class, args);

        logger.info("Initializing SafetyNet Alert");
		launchingService.LaunchApplication();
	}
}