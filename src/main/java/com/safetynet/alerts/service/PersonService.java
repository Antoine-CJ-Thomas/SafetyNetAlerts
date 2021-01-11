package com.safetynet.alerts.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jsoniter.output.JsonStream;
import com.safetynet.alerts.dto.AdultDTO;
import com.safetynet.alerts.dto.ChildAlertDTO;
import com.safetynet.alerts.dto.ChildDTO;
import com.safetynet.alerts.dto.FireAlertDTO;
import com.safetynet.alerts.dto.FloodAlertDTO;
import com.safetynet.alerts.dto.HomeDTO;
import com.safetynet.alerts.dto.InhabitantDTO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;

/**
 * This class allows to perform actions on a repository of persons
 */
@Service
public class PersonService {

    private static final Logger logger = LogManager.getLogger("PersonService");

	public ArrayList<Person> getPersonList(PersonRepository personRepository) {
        logger.info("getPersonList(" + personRepository + ")");
		return personRepository.getPersonList();
	}

	public Person addPerson(PersonRepository personRepository, Person person) {
        logger.info("addPerson(" + personRepository + ", " + person + ")");
		return personRepository.addPerson(person);
	}

	public Person updatePerson(PersonRepository personRepository, Person person) {
        logger.info("updatePerson(" + personRepository + ", " + person + ")");

        int personIndex = -1;
		
		for (Person p : personRepository.getPersonList()) {

			if (p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())) {
				personIndex = personRepository.getPersonList().indexOf(p);
				break;
			}
		}
		return personRepository.updatePerson(personIndex, person);
		
	}

	public Person removePerson(PersonRepository personRepository, Person person) {
        logger.info("removePerson(" + personRepository + ", " + person + ")");

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
        logger.info("getPhoneList(" + personRepository + ", " + fireStationRepository + ", " + firestation + ")");

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
        logger.info("getCommunityEmailList(" + personRepository + ", " + city + ")");
		
		ArrayList<String> emailList = new ArrayList<String>();

		for (Person p : personRepository.getPersonList()) {

			if (p.getCity().equals(city)) {
				
				emailList.add(p.getEmail());
			}
		}
		return emailList;
	}
	
	public String getFireInfo(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository, String adress) {
        logger.info("getFireInfo(" + personRepository + ", " + fireStationRepository + ", " + medicalRecordRepository + ", " + adress + ")");
		
		String stationNumber = null;

		for (FireStation f : fireStationRepository.getFireStationList()) {

			if (f.getAddress().equals(adress)) {
				
				stationNumber = f.getStation();
			}
		}
		
		FireAlertDTO fireAlertDTO = new FireAlertDTO(adress, stationNumber);
		MedicalRecordService medicalRecordService = new MedicalRecordService();

		for (Person p : personRepository.getPersonList()) {

			if (p.getAddress().equals(adress)) {
								
				fireAlertDTO.getInhabitants().add(new InhabitantDTO(p.getLastName(), p.getPhone(), medicalRecordService.getAge(medicalRecordRepository, p.getFirstName(), p.getLastName()), medicalRecordService.getMedicationList(medicalRecordRepository, p.getFirstName(), p.getLastName()), medicalRecordService.getAllergieList(medicalRecordRepository, p.getFirstName(), p.getLastName())));
			}
		}
		return JsonStream.serialize(fireAlertDTO);
	}
	
	public String getFloodInfo(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository, String firestation) {
        logger.info("getFloodInfo(" + personRepository + ", " + fireStationRepository + ", " + medicalRecordRepository + ", " + firestation + ")");
		
		ArrayList<String> fireStationAddressList = new ArrayList<String>();
		
		for (FireStation f: fireStationRepository.getFireStationList()) {
			
			if (f.getStation().equals(firestation)) {
				
				fireStationAddressList.add(f.getAddress());
			}
		}
		
		FloodAlertDTO floodInfoResponse = new FloodAlertDTO(firestation);
		MedicalRecordService medicalRecordService = new MedicalRecordService();
		
		for (String s : fireStationAddressList) {
			
			HomeDTO home = new HomeDTO(s);
			
			floodInfoResponse.getHomes().add(home);
			
			for (Person p : personRepository.getPersonList()) {

				if (p.getAddress().equals(s)) {
									
					home.getInhabitants().add(new InhabitantDTO(p.getLastName(), p.getPhone(), medicalRecordService.getAge(medicalRecordRepository, p.getFirstName(), p.getLastName()), medicalRecordService.getMedicationList(medicalRecordRepository, p.getFirstName(), p.getLastName()), medicalRecordService.getAllergieList(medicalRecordRepository, p.getFirstName(), p.getLastName())));
				}
			}
		}
		
		return JsonStream.serialize(floodInfoResponse);
	}

	public String getChildAlertInfo(PersonRepository personRepository, MedicalRecordRepository medicalRecordRepository, String adress) {
        logger.info("getChildAlertInfo(" + personRepository + ", " + medicalRecordRepository + ", " + adress + ")");

		ChildAlertDTO childAlertResponse = new ChildAlertDTO(adress);
		MedicalRecordService medicalRecordService = new MedicalRecordService();
		
		for (Person p : personRepository.getPersonList()) {

			if (p.getAddress().equals(adress)) {
				
				if (Integer.parseInt(medicalRecordService.getAge(medicalRecordRepository, p.getFirstName(), p.getLastName())) <= 18) {
					
					childAlertResponse.getChilds().add(new ChildDTO(p.getFirstName(), p.getLastName(), medicalRecordService.getAge(medicalRecordRepository, p.getFirstName(), p.getLastName())));
				}
				
				else {

					childAlertResponse.getAdults().add(new AdultDTO(p.getFirstName(), p.getLastName()));
					
				}			
			}
		}
		
		return JsonStream.serialize(childAlertResponse);
	}
}