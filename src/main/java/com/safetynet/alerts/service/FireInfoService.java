package com.safetynet.alerts.service;

import com.jsoniter.output.JsonStream;
import com.safetynet.alerts.dto.FireStationDTO;
import com.safetynet.alerts.dto.MedicalRecordDTO;
import com.safetynet.alerts.dto.PersonDTO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.response.FireInfoResponse;

public class FireInfoService {
	
	public String getFireInfo(PersonDTO personDTO, FireStationDTO fireStationDTO, MedicalRecordDTO medicalRecordDTO, String adress) {
		
		String stationNumber = null;

		for (FireStation f : fireStationDTO.getFireStationList()) {

			if (f.getAddress().equals(adress)) {
				
				stationNumber = f.getStation();
			}
		}
		
		FireInfoResponse fireInfoResponse = new FireInfoResponse(adress, stationNumber);
		MedicalRecordService medicalRecordService = new MedicalRecordService();

		for (Person p : personDTO.getPersonList()) {

			if (p.getAddress().equals(adress)) {
								
				fireInfoResponse.addInhabitant(p.getLastName(), p.getPhone(), medicalRecordService.getAge(medicalRecordDTO, p.getFirstName(), p.getLastName()), medicalRecordService.getMedicationList(medicalRecordDTO, p.getFirstName(), p.getLastName()), medicalRecordService.getAllergieList(medicalRecordDTO, p.getFirstName(), p.getLastName()));
			}
		}
		return JsonStream.serialize(fireInfoResponse);
	}
}
