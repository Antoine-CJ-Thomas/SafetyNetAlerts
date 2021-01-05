package com.safetynet.alerts.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.FireStationService;

@RestController
public class FireStationController {

    private static final Logger logger = LogManager.getLogger("FireStationController");

	@Autowired
	private FireStationService fireStationService;

	private static PersonRepository personRepository;
	private static FireStationRepository fireStationRepository;
	private static MedicalRecordRepository medicalRecordRepository;

	public FireStationController(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository) {
		FireStationController.personRepository = personRepository;
		FireStationController.fireStationRepository = fireStationRepository;
		FireStationController.medicalRecordRepository = medicalRecordRepository;
	}

	@GetMapping("/firestation")
	public ArrayList<FireStation> getFireStationList() {
        logger.info("getFireStationList()");
		return fireStationService.getFireStationList(fireStationRepository);
	}

	@PostMapping("/firestation")
	public FireStation addFireStation(@RequestBody FireStation fireStation) {
        logger.info("addFireStation()");
		return fireStationService.addFireStation(fireStationRepository, fireStation);
	}

	@PutMapping("/firestation")
	public FireStation updateFireStation(@RequestBody FireStation fireStation) {
        logger.info("updateFireStation()");
		return fireStationService.updateFireStation(fireStationRepository, fireStation);
	}

	@DeleteMapping("/firestation")
	public FireStation removeFireStation(@RequestBody FireStation fireStation) {
        logger.info("removeFireStation()");
		return fireStationService.removeFireStation(fireStationRepository, fireStation);
	}

	@GetMapping("/firestation/{firestation}")
	public String firestationCoverage(@PathVariable("firestation") final String firestation) {
        logger.info("firestationCoverage(" + firestation + ")");
		return fireStationService.getFirestationCoverage(personRepository, fireStationRepository, medicalRecordRepository, firestation);
	}
}