package com.safetynet.alerts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsoniter.output.JsonStream;
import com.safetynet.alerts.dto.FirestationCoverageInfoDTO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.FireStationService;
import com.safetynet.alerts.service.MedicalRecordService;

/**
 * This class allows to interact with the application via fire station http requests
 */
@RestController
public class FireStationController {

    private static final Logger logger = LogManager.getLogger("FireStationController");

	private static FireStationService fireStationService;
	private static MedicalRecordService medicalRecordService;
	
	public FireStationController(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository) {		
        logger.info("FireStationController(" + personRepository + ", " + fireStationRepository + ", " + medicalRecordRepository + ")");
        
		fireStationService = new FireStationService(personRepository, fireStationRepository, medicalRecordRepository);
		medicalRecordService = new MedicalRecordService(personRepository, fireStationRepository, medicalRecordRepository);
	}

	@GetMapping("/firestation")
	public String getFireStationList() {
        logger.info("getFireStationList()");
		return JsonStream.serialize(fireStationService.getFireStationList());
	}

	@PostMapping("/firestation")
	public String addFireStation(@RequestBody FireStation fireStation) {
        logger.info("addFireStation()");
		return JsonStream.serialize(fireStationService.addFireStation(fireStation));
	}

	@PutMapping("/firestation")
	public String updateFireStation(@RequestBody FireStation fireStation) {
        logger.info("updateFireStation()");
		return JsonStream.serialize(fireStationService.updateFireStation(fireStation));
	}

	@DeleteMapping("/firestation")
	public String removeFireStation(@RequestBody FireStation fireStation) {
        logger.info("removeFireStation()");
		return JsonStream.serialize(fireStationService.removeFireStation(fireStation));
	}

	@GetMapping("/firestation/{station}")
	public String firestationCoverage(@PathVariable("station") final String station) {
        logger.info("firestationCoverage(" + station + ")");
		return JsonStream.serialize(fireStationService.getFirestationCoverage(medicalRecordService, new FirestationCoverageInfoDTO(station)));
	}
}