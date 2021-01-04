package com.safetynet.alerts.service;

import com.jsoniter.output.JsonStream;
import com.safetynet.alerts.dto.FireStationDTO;
import com.safetynet.alerts.dto.MedicalRecordDTO;
import com.safetynet.alerts.dto.PersonDTO;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.response.ChildAlertResponse;

public class ChildAlertService {

	public String getChildAlertInfo(PersonDTO personDTO, FireStationDTO fireStationDTO, MedicalRecordDTO medicalRecordDTO, String adress) {

		ChildAlertResponse childAlertResponse = new ChildAlertResponse(adress);
		MedicalRecordService medicalRecordService = new MedicalRecordService();
		
		for (Person p : personDTO.getPersonList()) {

			if (p.getAddress().equals(adress)) {
				
				if (Integer.parseInt(medicalRecordService.getAge(medicalRecordDTO, p.getFirstName(), p.getLastName())) <= 18) {
					
					childAlertResponse.addChild(p.getFirstName(), p.getLastName(), medicalRecordService.getAge(medicalRecordDTO, p.getFirstName(), p.getLastName()));
				}
				
				else {

					childAlertResponse.addAdult(p.getFirstName(), p.getLastName());
					
				}			
			}
		}
		
		return JsonStream.serialize(childAlertResponse);
	}
}
