package com.safetynet.alerts.service;

import java.util.ArrayList;

import com.safetynet.alerts.dto.FireStationDTO;
import com.safetynet.alerts.dto.MedicalRecordDTO;
import com.safetynet.alerts.dto.PersonDTO;
import com.safetynet.alerts.model.Person;

public class CommunityEmailService {
	
	public ArrayList<String> getCommunityEmailList(PersonDTO personDTO, FireStationDTO fireStationDTO, MedicalRecordDTO medicalRecordDTO, String city) {
		
		ArrayList<String> emailList = new ArrayList<String>();

		for (Person p : personDTO.getPersonList()) {

			if (p.getCity().equals(city)) {
				
				emailList.add(p.getEmail());
			}
		}
		return emailList;
	}
}
