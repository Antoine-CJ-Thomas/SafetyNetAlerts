package com.safetynet.alerts.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.controller.FireStationController;
import com.safetynet.alerts.controller.MedicalRecordController;
import com.safetynet.alerts.controller.PersonController;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;

/**
 * This class allow to launch the application
 */
@Service
public class LaunchingService {

    private static final Logger logger = LogManager.getLogger("LaunchingService");

	public void LaunchApplication() {
        logger.info("LaunchApplication()");
		
		String filePath = "src/main/resources/data.json";

		PersonRepository personRepository = new PersonRepository();
		FireStationRepository fireStationRepository = new FireStationRepository();
		MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();
		JsonFileReader jsonFileReader = new JsonFileReader();

		PersonController personController = new PersonController(personRepository, fireStationRepository, medicalRecordRepository);
		FireStationController fireStationController = new FireStationController(personRepository, fireStationRepository, medicalRecordRepository);
		MedicalRecordController medicalRecordController = new MedicalRecordController(personRepository, fireStationRepository, medicalRecordRepository);

		jsonFileReader.readFile(filePath, personRepository, fireStationRepository, medicalRecordRepository);
	}
}
