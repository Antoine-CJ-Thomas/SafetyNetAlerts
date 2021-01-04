package com.safetynet.alerts.service;

import org.springframework.stereotype.Service;

import com.safetynet.alerts.controller.FireStationController;
import com.safetynet.alerts.controller.MedicalRecordController;
import com.safetynet.alerts.controller.PersonController;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;

@Service
public class LaunchingService {

	public void LaunchApplication() {
		
		String filePath = "src/main/resources/data.json";

		PersonRepository personRepository = new PersonRepository();
		FireStationRepository fireStationRepository = new FireStationRepository();
		MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

		JsonFileReader jsonFileReader = new JsonFileReader(filePath, personRepository, fireStationRepository, medicalRecordRepository);

		PersonController personController = new PersonController(personRepository, fireStationRepository, medicalRecordRepository);
		FireStationController fireStationController = new FireStationController(personRepository, fireStationRepository, medicalRecordRepository);
		MedicalRecordController medicalRecordController = new MedicalRecordController(personRepository, fireStationRepository, medicalRecordRepository);

		jsonFileReader.readFile();
	}
}
