package com.safetynet.alerts.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.jsoniter.output.JsonStream;
import com.safetynet.alerts.dto.ChildAlertDTO;
import com.safetynet.alerts.dto.FireAlertDTO;
import com.safetynet.alerts.dto.FloodAlertDTO;
import com.safetynet.alerts.dto.PersonInfoDTO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;

@Service
public class PersonService {

	public ArrayList<Person> getPersonList(PersonRepository personRepository) {
		return personRepository.getPersonList();
	}

	public Person addPerson(PersonRepository personRepository, Person person) {
		return personRepository.addPerson(person);
	}

	public Person updatePerson(PersonRepository personRepository, Person person) {

		Person updatedPerson = null;
		
		for (Person p : personRepository.getPersonList()) {

			if (p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())) {
				updatedPerson = p;
				break;
			}
		}		
		return personRepository.updatePerson(personRepository.getPersonList().indexOf(updatedPerson), person);
		
	}

	public Person removePerson(PersonRepository personRepository, Person person) {

		Person deletedPerson = null;

		for (Person p : personRepository.getPersonList()) {

			if (p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())) {
				deletedPerson = p;
				break;
			}
		}
		return personRepository.removePerson(deletedPerson);
	}
	
	public ArrayList<String> getPhoneList(PersonRepository personRepository, FireStationRepository fireStationRepository, String firestation) {

		ArrayList<String> firestationAdressList = new ArrayList<String>();

		for (FireStation f : fireStationRepository.getFireStationList()) {

			if (f.getStation().equals(firestation)) {
				
				firestationAdressList.add(f.getAddress());
			}
		}
		
		ArrayList<String> phoneList = new ArrayList<String>();

		for (Person p : personRepository.getPersonList()) {

			if (firestationAdressList.contains(p.getAddress())) {
				
				phoneList.add(p.getPhone());
			}
		}
		return phoneList;
	}
	
	public ArrayList<String> getCommunityEmailList(PersonRepository personRepository, String city) {
		
		ArrayList<String> emailList = new ArrayList<String>();

		for (Person p : personRepository.getPersonList()) {

			if (p.getCity().equals(city)) {
				
				emailList.add(p.getEmail());
			}
		}
		return emailList;
	}
	
	public String getFireInfo(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository, String adress) {
		
		String stationNumber = null;

		for (FireStation f : fireStationRepository.getFireStationList()) {

			if (f.getAddress().equals(adress)) {
				
				stationNumber = f.getStation();
			}
		}
		
		FireAlertDTO fireInfoResponse = new FireAlertDTO(adress, stationNumber);
		MedicalRecordService medicalRecordService = new MedicalRecordService();

		for (Person p : personRepository.getPersonList()) {

			if (p.getAddress().equals(adress)) {
								
				fireInfoResponse.addInhabitant(p.getLastName(), p.getPhone(), medicalRecordService.getAge(medicalRecordRepository, p.getFirstName(), p.getLastName()), medicalRecordService.getMedicationList(medicalRecordRepository, p.getFirstName(), p.getLastName()), medicalRecordService.getAllergieList(medicalRecordRepository, p.getFirstName(), p.getLastName()));
			}
		}
		return JsonStream.serialize(fireInfoResponse);
	}
	
	public String getFloodInfo(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository, String firestation) {
		
		ArrayList<String> fireStationAddressList = new ArrayList<String>();
		
		for (FireStation f: fireStationRepository.getFireStationList()) {
			
			if (f.getStation().equals(firestation)) {
				
				fireStationAddressList.add(f.getAddress());
			}
		}
		
		FloodAlertDTO floodInfoResponse = new FloodAlertDTO(firestation);
		MedicalRecordService medicalRecordService = new MedicalRecordService();
		
		for (String s : fireStationAddressList) {
			
			floodInfoResponse.addHome(s);
			
			for (Person p : personRepository.getPersonList()) {

				if (p.getAddress().equals(s)) {
									
					floodInfoResponse.addInhabitantToHome(s, p.getLastName(), p.getPhone(), medicalRecordService.getAge(medicalRecordRepository, p.getFirstName(), p.getLastName()), medicalRecordService.getMedicationList(medicalRecordRepository, p.getFirstName(), p.getLastName()), medicalRecordService.getAllergieList(medicalRecordRepository, p.getFirstName(), p.getLastName()));
				}
			}
		}
		
		return JsonStream.serialize(floodInfoResponse);
	}

	public String getChildAlertInfo(PersonRepository personRepository, MedicalRecordRepository medicalRecordRepository, String adress) {

		ChildAlertDTO childAlertResponse = new ChildAlertDTO(adress);
		MedicalRecordService medicalRecordService = new MedicalRecordService();
		
		for (Person p : personRepository.getPersonList()) {

			if (p.getAddress().equals(adress)) {
				
				if (Integer.parseInt(medicalRecordService.getAge(medicalRecordRepository, p.getFirstName(), p.getLastName())) <= 18) {
					
					childAlertResponse.addChild(p.getFirstName(), p.getLastName(), medicalRecordService.getAge(medicalRecordRepository, p.getFirstName(), p.getLastName()));
				}
				
				else {

					childAlertResponse.addAdult(p.getFirstName(), p.getLastName());
					
				}			
			}
		}
		
		return JsonStream.serialize(childAlertResponse);
	}
}