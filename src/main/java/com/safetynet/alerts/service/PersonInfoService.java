package com.safetynet.alerts.service;

import com.jsoniter.output.JsonStream;
import com.safetynet.alerts.dto.FireStationDTO;
import com.safetynet.alerts.dto.MedicalRecordDTO;
import com.safetynet.alerts.dto.PersonDTO;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.response.PersonInfoResponse;

public class PersonInfoService {
	
	public String getPersonInfo(PersonDTO personDTO, FireStationDTO fireStationDTO, MedicalRecordDTO medicalRecordDTO, String name) {

	    String[] namePart = name.split(" ");
	    
		String firstName = namePart[0];
		String lastName = namePart[1];
		
		PersonInfoResponse personInfoResponse = new PersonInfoResponse(firstName, lastName);
		MedicalRecordService medicalRecordService = new MedicalRecordService();
		
		for (Person p : personDTO.getPersonList()) {

			if (p.getLastName().equals(lastName)) {
				
				personInfoResponse.addPersonInfo(p.getLastName(), p.getAddress(), medicalRecordService.getAge(medicalRecordDTO, p.getFirstName(), p.getLastName()), medicalRecordService.getMedicationList(medicalRecordDTO, p.getFirstName(), p.getLastName()), medicalRecordService.getAllergieList(medicalRecordDTO, p.getFirstName(), p.getLastName()));	
	
			}
		}
		return JsonStream.serialize(personInfoResponse);
	}
}
