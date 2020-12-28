package com.safetynet.alerts.service;


import org.springframework.stereotype.Service;

import com.safetynet.alerts.controller.FireStationController;
import com.safetynet.alerts.controller.MedicalRecordController;
import com.safetynet.alerts.controller.PersonController;
import com.safetynet.alerts.dto.FireStationDTO;
import com.safetynet.alerts.dto.MedicalRecordDTO;
import com.safetynet.alerts.dto.PersonDTO;

@Service
public class LaunchService {

	public LaunchService() {
		
		String filePath = "src/main/resources/data.json";

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
