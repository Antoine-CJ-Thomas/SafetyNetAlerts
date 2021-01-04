package com.safetynet.alerts.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.MedicalRecordService;

@RestController
public class MedicalRecordController {

	@Autowired
	private MedicalRecordService medicalRecordService;

	private static PersonRepository personRepository;
	private static FireStationRepository fireStationRepository;
	private static MedicalRecordRepository medicalRecordRepository;

	public MedicalRecordController(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository) {
		MedicalRecordController.personRepository = personRepository;
		MedicalRecordController.fireStationRepository = fireStationRepository;
		MedicalRecordController.medicalRecordRepository = medicalRecordRepository;
	}

	@GetMapping("/medicalRecord")
	public ArrayList<MedicalRecord> getMedicalRecordList() {
		return medicalRecordService.getMedicalRecordList(medicalRecordRepository);
	}

	@PostMapping("/medicalRecord")
	public MedicalRecord addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return medicalRecordService.addMedicalRecord(medicalRecordRepository, medicalRecord);
	}

	@PutMapping("/medicalRecord")
	public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return medicalRecordService.updateMedicalRecord(medicalRecordRepository, medicalRecord);
	}

	@DeleteMapping("/medicalRecord")
	public MedicalRecord removeMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return medicalRecordService.removeMedicalRecord(medicalRecordRepository, medicalRecord);
	}

	@GetMapping("/personInfo/{name}")
	public String personInfo(@PathVariable("name") final String name) {
		return medicalRecordService.getPersonInfo(personRepository, medicalRecordRepository, name);
	}
}