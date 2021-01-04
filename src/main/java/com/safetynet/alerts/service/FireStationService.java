package com.safetynet.alerts.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.jsoniter.output.JsonStream;
import com.safetynet.alerts.dto.FirestationCoverageDTO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;

@Service
public class FireStationService {

	public ArrayList<FireStation> getFireStationList(FireStationRepository fireStationRepository) {
		return fireStationRepository.getFireStationList();
	}

	public FireStation addFireStation(FireStationRepository fireStationRepository, FireStation fireStation) {
		return fireStationRepository.addFireStation(fireStation);
	}

	public FireStation updateFireStation(FireStationRepository fireStationRepository, FireStation fireStation) {

		FireStation updatedFireStation = null;
		
		for (FireStation f : fireStationRepository.getFireStationList()) {

			if (f.getAddress().equals(fireStation.getAddress())) {
				updatedFireStation = f;
				break;
			}
		}		
		return fireStationRepository.updateFireStation(fireStationRepository.getFireStationList().indexOf(updatedFireStation), fireStation);
	}

	public FireStation removeFireStation(FireStationRepository fireStationRepository, FireStation fireStation) {

		FireStation deletedFireStation = null;

		for (FireStation f : fireStationRepository.getFireStationList()) {

			if (f.getAddress().equals(fireStation.getAddress())) {
				deletedFireStation = f;
				break;
			}
		}
		return fireStationRepository.removeFireStation(deletedFireStation);
	}

	public String getFirestationCoverage(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository, String firestation) {

		ArrayList<String> firestationAdressList = new ArrayList<String>();

		for (FireStation f : fireStationRepository.getFireStationList()) {

			if (f.getStation().equals(firestation)) {
				
				firestationAdressList.add(f.getAddress());
			}
		}
		
		ArrayList<Person> personList = new ArrayList<Person>();
		FirestationCoverageDTO firestationCoverageResponse = new FirestationCoverageDTO(firestation);

		for (Person p : personRepository.getPersonList()) {

			if (firestationAdressList.contains(p.getAddress())) {

				personList.add(p);
			}
		}

		MedicalRecordService medicalRecordService = new MedicalRecordService();
		
		for (Person p : personList) {

			firestationCoverageResponse.addContact(p.getFirstName(), p.getLastName(), p.getAddress(), p.getPhone());
			
			if (Integer.parseInt(medicalRecordService.getAge(medicalRecordRepository, p.getFirstName(), p.getLastName())) <= 18) {
				
				firestationCoverageResponse.increaseChildCounter();
			}
			
			else {

				firestationCoverageResponse.increaseAdultCounter();
						
			}
		}
		
		return JsonStream.serialize(firestationCoverageResponse);
	}
}