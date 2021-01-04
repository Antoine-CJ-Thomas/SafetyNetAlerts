package com.safetynet.alerts.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.dto.FireStationDTO;
import com.safetynet.alerts.dto.MedicalRecordDTO;
import com.safetynet.alerts.dto.PersonDTO;
import com.safetynet.alerts.service.ChildAlertService;
import com.safetynet.alerts.service.CommunityEmailService;
import com.safetynet.alerts.service.FireInfoService;
import com.safetynet.alerts.service.FirestationCoverageService;
import com.safetynet.alerts.service.FloodInfoService;
import com.safetynet.alerts.service.PhoneAlertService;

@RestController
public class CrossController {

	private static PersonDTO personDTO;
	private static FireStationDTO fireStationDTO;
	private static MedicalRecordDTO medicalRecordDTO;

	private static FireInfoService fireInfoService = new FireInfoService();
	private static FloodInfoService floodInfoService = new FloodInfoService();
	private static PhoneAlertService phoneAlertService = new PhoneAlertService();
	private static ChildAlertService childAlertService = new ChildAlertService();
	private static CommunityEmailService communityEmailService = new CommunityEmailService();
	private static FirestationCoverageService firestationCoverageService = new FirestationCoverageService();

	public CrossController(PersonDTO personDTO, FireStationDTO fireStationDTO, MedicalRecordDTO medicalRecordDTO) {
		this.personDTO = personDTO;
		this.fireStationDTO = fireStationDTO;
		this.medicalRecordDTO = medicalRecordDTO;
	}

	@GetMapping("/firestation/{firestation}")
	public String firestationCoverage(@PathVariable("firestation") final String firestation) {
		return firestationCoverageService.getCoverage(personDTO, fireStationDTO, medicalRecordDTO, firestation);
	}

	@GetMapping("/childAlert/{adress}")
	public String childAlert(@PathVariable("adress") final String adress) {
		return childAlertService.getChildAlertInfo(personDTO, fireStationDTO, medicalRecordDTO, adress);
	}

	@GetMapping("/phoneAlert/{firestation}")
	public ArrayList<String> phoneAlert(@PathVariable("firestation") final String firestation) {
		return phoneAlertService.getPhoneList(personDTO, fireStationDTO, medicalRecordDTO, firestation);
	}

	@GetMapping("/fire/{adress}")
	public String fireInfo(@PathVariable("adress") final String adress) {
		return fireInfoService.getFireInfo(personDTO, fireStationDTO, medicalRecordDTO, adress);
	}

	@GetMapping("/flood/{firestation}")
	public String floodInfo(@PathVariable("firestation") final String firestation) {
		return floodInfoService.getFloodInfo(personDTO, fireStationDTO, medicalRecordDTO, firestation);
	}

	@GetMapping("/personInfo/{firstName} {lastName}")
	public String personInfo(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName) {
		return null;
	}

	@GetMapping("/communityEmail/{city}")
	public ArrayList<String> communityEmail(@PathVariable("city") final String city) {
		return communityEmailService.getCommunityEmailList(personDTO, fireStationDTO, medicalRecordDTO, city);
	}
}