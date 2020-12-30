package com.safetynet.alerts.service;

import java.util.ArrayList;

import com.jsoniter.output.JsonStream;
import com.safetynet.alerts.dto.FireStationDTO;
import com.safetynet.alerts.dto.MedicalRecordDTO;
import com.safetynet.alerts.dto.PersonDTO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.response.FloodInfoResponse;

public class FloodInfoService {
	
	public String getFloodInfo(PersonDTO personDTO, FireStationDTO fireStationDTO, MedicalRecordDTO medicalRecordDTO, String firestation) {
		
		ArrayList<String> fireStationAddressList = new ArrayList<String>();
		
		for (FireStation f: fireStationDTO.getFireStationList()) {
			
			if (f.getStation().equals(firestation)) {
				
				fireStationAddressList.add(f.getAddress());
			}
		}
		
		FloodInfoResponse floodInfoResponse = new FloodInfoResponse(firestation);
		MedicalRecordService medicalRecordService = new MedicalRecordService();
		
		for (String s : fireStationAddressList) {
			
			floodInfoResponse.addHome(s);
			
			for (Person p : personDTO.getPersonList()) {

				if (p.getAddress().equals(s)) {
									
					floodInfoResponse.addInhabitantToHome(s, p.getLastName(), p.getPhone(), medicalRecordService.getAge(medicalRecordDTO, p.getFirstName(), p.getLastName()), medicalRecordService.getMedicationList(medicalRecordDTO, p.getFirstName(), p.getLastName()), medicalRecordService.getAllergieList(medicalRecordDTO, p.getFirstName(), p.getLastName()));
				}
			}
		}
		
		return JsonStream.serialize(floodInfoResponse);
	}
}
