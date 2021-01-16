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
import com.safetynet.alerts.dto.PersonInfoDTO;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.MedicalRecordService;

/**
 * This class allows to interact with the application via medical record http requests
 */
@RestController
public class MedicalRecordController {

    private static final Logger logger = LogManager.getLogger("MedicalRecordController");

	private static MedicalRecordService medicalRecordService;

	public MedicalRecordController(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository) {
        logger.info("MedicalRecordController(" + personRepository + ", " + fireStationRepository + ", " + medicalRecordRepository + ")");
        
        medicalRecordService = new MedicalRecordService(personRepository, fireStationRepository, medicalRecordRepository);
	}

	@GetMapping("/medicalRecord")
	public String getMedicalRecordList() {
        logger.info("getMedicalRecordList()");
		return JsonStream.serialize(medicalRecordService.getMedicalRecordList());
	}

	@PostMapping("/medicalRecord")
	public String addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        logger.info("addMedicalRecord()");
		return JsonStream.serialize(medicalRecordService.addMedicalRecord(medicalRecord));
	}

	@PutMapping("/medicalRecord")
	public String updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        logger.info("updateMedicalRecord()");
		return JsonStream.serialize(medicalRecordService.updateMedicalRecord(medicalRecord));
	}

	@DeleteMapping("/medicalRecord")
	public String removeMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        logger.info("removeMedicalRecord()");
		return JsonStream.serialize(medicalRecordService.removeMedicalRecord(medicalRecord));
	}

	@GetMapping("/personInfo/{name}")
	public String personInfo(@PathVariable("name") final String name) {
        logger.info("personInfo(" + name + ")");
		return JsonStream.serialize(medicalRecordService.getPersonInfo(new PersonInfoDTO(name)));
	}
}