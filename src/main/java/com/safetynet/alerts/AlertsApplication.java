package com.safetynet.alerts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safetynet.alerts.controller.FireStationController;
import com.safetynet.alerts.controller.MedicalRecordController;
import com.safetynet.alerts.controller.PersonController;
import com.safetynet.alerts.dto.FireStationDTO;
import com.safetynet.alerts.dto.MedicalRecordDTO;
import com.safetynet.alerts.dto.PersonDTO;
import com.safetynet.alerts.service.JsonFileReader;

@SpringBootApplication
public class AlertsApplication {

	public static void main(String[] args) {

		String filePath = "src/main/resources/data.json";

		SpringApplication.run(AlertsApplication.class, args);

		PersonDTO personDAO = new PersonDTO();
		FireStationDTO fireStationDAO = new FireStationDTO();
		MedicalRecordDTO medicalRecordDAO = new MedicalRecordDTO();

		JsonFileReader jsonFileReader = new JsonFileReader(filePath, personDAO, fireStationDAO, medicalRecordDAO);

		PersonController personController = new PersonController(personDAO);
		FireStationController fireStationController = new FireStationController(fireStationDAO);
		MedicalRecordController medicalRecordController = new MedicalRecordController(medicalRecordDAO);

		jsonFileReader.readFile();
	}
}