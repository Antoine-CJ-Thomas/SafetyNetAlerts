package com.safetynet.alerts.service;

import java.util.ArrayList;

import com.safetynet.alerts.dto.FireStationDTO;
import com.safetynet.alerts.dto.MedicalRecordDTO;
import com.safetynet.alerts.dto.PersonDTO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;

public class PhoneAlertService {
	
	public ArrayList<String> getPhoneList(PersonDTO personDTO, FireStationDTO fireStationDTO, MedicalRecordDTO medicalRecordDTO, String firestation) {

		ArrayList<String> firestationAdressList = new ArrayList<String>();

		for (FireStation f : fireStationDTO.getFireStationList()) {

			if (f.getStation().equals(firestation)) {
				
				firestationAdressList.add(f.getAddress());
			}
		}
		
		ArrayList<String> phoneList = new ArrayList<String>();

		for (Person p : personDTO.getPersonList()) {

			if (firestationAdressList.contains(p.getAddress())) {
				
				phoneList.add(p.getPhone());
			}
		}
		return phoneList;
	}
}
