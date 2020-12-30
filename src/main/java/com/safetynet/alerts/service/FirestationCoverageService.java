package com.safetynet.alerts.service;

import java.util.ArrayList;

import com.jsoniter.output.JsonStream;
import com.safetynet.alerts.dto.FireStationDTO;
import com.safetynet.alerts.dto.MedicalRecordDTO;
import com.safetynet.alerts.dto.PersonDTO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.response.FirestationCoverageResponse;

public class FirestationCoverageService {

	public String getFirestationCoverage(PersonDTO personDTO, FireStationDTO fireStationDTO, MedicalRecordDTO medicalRecordDTO, String firestation) {

		ArrayList<String> firestationAdressList = new ArrayList<String>();

		for (FireStation f : fireStationDTO.getFireStationList()) {

			if (f.getStation().equals(firestation)) {
				
				firestationAdressList.add(f.getAddress());
			}
		}
		
		ArrayList<Person> personList = new ArrayList<Person>();
		FirestationCoverageResponse firestationCoverageResponse = new FirestationCoverageResponse(firestation);

		for (Person p : personDTO.getPersonList()) {

			if (firestationAdressList.contains(p.getAddress())) {

				personList.add(p);
			}
		}

		MedicalRecordService medicalRecordService = new MedicalRecordService();
		
		for (Person p : personList) {

			firestationCoverageResponse.addPerson(p.getFirstName(), p.getLastName(), p.getAddress(), p.getPhone());
			
			if (Integer.parseInt(medicalRecordService.getAge(medicalRecordDTO, p.getFirstName(), p.getLastName())) <= 18) {
				
				firestationCoverageResponse.increaseChildCounter();
			}
			
			else {

				firestationCoverageResponse.increaseAdultCounter();
						
			}
		}
		
		return JsonStream.serialize(firestationCoverageResponse);
	}
}
