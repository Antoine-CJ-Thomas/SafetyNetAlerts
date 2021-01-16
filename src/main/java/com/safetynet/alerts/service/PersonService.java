package com.safetynet.alerts.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.dto.AdultDTO;
import com.safetynet.alerts.dto.ChildDTO;
import com.safetynet.alerts.dto.ChildInfoDTO;
import com.safetynet.alerts.dto.CommunityEmailInfoDTO;
import com.safetynet.alerts.dto.FireInfoDTO;
import com.safetynet.alerts.dto.FloodInfoDTO;
import com.safetynet.alerts.dto.HomeDTO;
import com.safetynet.alerts.dto.InhabitantDTO;
import com.safetynet.alerts.dto.PhoneInfoDTO;
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

	private PersonRepository personRepository;
	private FireStationRepository fireStationRepository;
	private MedicalRecordRepository medicalRecordRepository;

    public PersonService(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository) {
        logger.info("PersonService(" + personRepository + ", " + fireStationRepository + ", " + medicalRecordRepository + ")");
        
    	this.personRepository = personRepository;
		this.fireStationRepository = fireStationRepository;
		this.medicalRecordRepository = medicalRecordRepository;
    }

	public ArrayList<Person> getPersonList() {
        logger.info("getPersonList()");
		return personRepository.getPersonList();
	}

	public Person addPerson(Person person) {
        logger.info("addPerson(" + person + ")");
        
		return personRepository.addPerson(person);
	}

	public Person updatePerson(Person person) {
        logger.info("updatePerson(" + person + ")");

		int index = -1;
		
		for (Person p : personRepository.getPersonList()) {

			if (p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())) {
				index = personRepository.getPersonList().indexOf(p);
				break;
			}
		}
		
		return personRepository.updatePerson(index, person);
		
	}

	public Person removePerson(Person person) {
        logger.info("removePerson(" + person + ")");

		int index = -1;

		for (Person p : personRepository.getPersonList()) {

			if (p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())) {
				index = personRepository.getPersonList().indexOf(p);
				break;
			}
		}
		
		return personRepository.removePerson(index, person);
	}

	public ChildInfoDTO getChildAlertInfo(MedicalRecordService medicalRecordService, ChildInfoDTO childInfoDTO) {
        logger.info("getFireInfo(" + medicalRecordService + ", " + childInfoDTO + ")");
		
		for (Person p : personRepository.getPersonList()) {

			System.out.println(p);
			
			if (p.getAddress().equals(childInfoDTO.getAddress())) {
				
				if (Integer.parseInt(medicalRecordService.getAge(p.getFirstName(), p.getLastName())) <= 18) {
					
					childInfoDTO.getChildList().add(new ChildDTO(p.getFirstName(), p.getLastName(), medicalRecordService.getAge(p.getFirstName(), p.getLastName())));
				}
				
				else {

					childInfoDTO.getAdultList().add(new AdultDTO(p.getFirstName(), p.getLastName()));
				}			
			}
		}
		
		return childInfoDTO;
	}
	
	public PhoneInfoDTO getPhoneInfo(PhoneInfoDTO phoneInfoDTO) {
        logger.info("getPhoneList(" + phoneInfoDTO + ")");

		for (FireStation f : fireStationRepository.getFireStationList()) {

			if (f.getStation().equals(phoneInfoDTO.getStation())) {
				
				phoneInfoDTO.getAddressList().add(f.getAddress());
			}
		}
		
		for (Person p : personRepository.getPersonList()) {

			if (phoneInfoDTO.getAddressList().contains(p.getAddress())) {
				
				phoneInfoDTO.getPhoneList().add(p.getPhone());
			}
		}
		return phoneInfoDTO;
	}
	
	public FireInfoDTO getFireInfo(MedicalRecordService medicalRecordService, FireInfoDTO fireInfoDTO) {
        logger.info("getFireInfo(" + medicalRecordService + ", " + fireInfoDTO + ")");
		
		for (FireStation f : fireStationRepository.getFireStationList()) {

			if (f.getAddress().equals(fireInfoDTO.getAddress())) {
				
				fireInfoDTO.setStation(f.getStation());
			}
		}

		for (Person p : personRepository.getPersonList()) {

			if (p.getAddress().equals(fireInfoDTO.getAddress())) {
								
				fireInfoDTO.getInhabitantList().add(new InhabitantDTO(p.getLastName(), p.getPhone(), medicalRecordService.getAge(p.getFirstName(), p.getLastName()), medicalRecordService.getMedicationList(p.getFirstName(), p.getLastName()), medicalRecordService.getAllergieList(p.getFirstName(), p.getLastName())));
			}
		}
		return fireInfoDTO;
	}
	
	public FloodInfoDTO getFloodInfo(MedicalRecordService medicalRecordService, FloodInfoDTO floodInfoDTO) {
        logger.info("getFireInfo(" + medicalRecordService + ", " + floodInfoDTO + ")");
				
		for (FireStation f: fireStationRepository.getFireStationList()) {
			
			if (floodInfoDTO.getStationList().contains(f.getStation())) {
				
				floodInfoDTO.getAddressList().add(f.getAddress());
			}
		}
					
		for (String s : floodInfoDTO.getAddressList()) {
						
			floodInfoDTO.getHomeList().add(new HomeDTO(s));
			
			for (Person p : personRepository.getPersonList()) {

				if (p.getAddress().equals(s)) {
									
					floodInfoDTO.getHomeList().get(floodInfoDTO.getHomeList().size()-1).getInhabitantList().add(new InhabitantDTO(p.getLastName(), p.getPhone(), medicalRecordService.getAge(p.getFirstName(), p.getLastName()), medicalRecordService.getMedicationList(p.getFirstName(), p.getLastName()), medicalRecordService.getAllergieList(p.getFirstName(), p.getLastName())));
				}
			}
		}
		
		return floodInfoDTO;
	}
	
	public CommunityEmailInfoDTO getCommunityEmailInfo(CommunityEmailInfoDTO communityEmailInfoDTO) {
        logger.info("getCommunityEmailList(" + communityEmailInfoDTO + ")");
		
		for (Person p : personRepository.getPersonList()) {

			if (p.getCity().equals(communityEmailInfoDTO.getCity())) {
				
				communityEmailInfoDTO.getEmailList().add(p.getEmail());
			}
		}
		
		return communityEmailInfoDTO;
	}
}