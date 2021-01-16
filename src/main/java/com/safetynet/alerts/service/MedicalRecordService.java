package com.safetynet.alerts.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.dto.HealthDTO;
import com.safetynet.alerts.dto.PersonInfoDTO;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;

/**
 * This class allows to perform actions on a repository of medical records
 */
@Service
public class MedicalRecordService {

    private static final Logger logger = LogManager.getLogger("MedicalRecordService");

	private PersonRepository personRepository;
	private FireStationRepository fireStationRepository;
	private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository) {
        logger.info("MedicalRecordService(" + personRepository + ", " + fireStationRepository + ", " + medicalRecordRepository + ")");
        
    	this.personRepository = personRepository;
		this.fireStationRepository = fireStationRepository;
		this.medicalRecordRepository = medicalRecordRepository;
    }

	public ArrayList<MedicalRecord> getMedicalRecordList() {
        logger.info("getMedicalRecordList()");
        
		return medicalRecordRepository.getMedicalRecordList();
	}

	public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
        logger.info("addMedicalRecord(" + medicalRecord + ")");
        		
		return medicalRecordRepository.addMedicalRecord(medicalRecord);
	}

	public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
        logger.info("updateMedicalRecord(" + medicalRecord + ")");

		int index = -1;
		
		for (MedicalRecord m : medicalRecordRepository.getMedicalRecordList()) {

			if (m.getFirstName().equals(medicalRecord.getFirstName()) && m.getLastName().equals(medicalRecord.getLastName())) {
				index = medicalRecordRepository.getMedicalRecordList().indexOf(m);
				break;
			}
		}	
		
		return medicalRecordRepository.updateMedicalRecord(index, medicalRecord);
	}

	public MedicalRecord removeMedicalRecord(MedicalRecord medicalRecord) {
        logger.info("removeMedicalRecord(" + medicalRecord + ")");

		int index = -1;

		for (MedicalRecord m : medicalRecordRepository.getMedicalRecordList()) {

			if (m.getFirstName().equals(medicalRecord.getFirstName()) && m.getLastName().equals(medicalRecord.getLastName())) {
				index = medicalRecordRepository.getMedicalRecordList().indexOf(m);
				break;
			}
		}
		
		return medicalRecordRepository.removeMedicalRecord(index, medicalRecord);
	}
	
	public String getAge(String firstName, String lastName) {
        logger.info("getAge(" + firstName + ", " + lastName + ")");

	    String age = null;
		LocalDate birthdate = null;
		LocalDate now = LocalDate.now();
		
		for (MedicalRecord m : medicalRecordRepository.getMedicalRecordList()) {

			if (m.getFirstName().equals(firstName) && m.getLastName().equals(lastName)) {
				
				birthdate = LocalDate.parse(m.getBirthdate(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			    age = String.valueOf(ChronoUnit.YEARS.between(birthdate, now));
				break;
			}
		}	
		
		return age;
	}
	
	public ArrayList<String> getMedicationList(String firstName, String lastName) {
        logger.info("getMedicationList(" + firstName + ", " + lastName + ")");

		ArrayList<String> medications = null;
		
		for (MedicalRecord m : medicalRecordRepository.getMedicalRecordList()) {

			if (m.getFirstName().equals(firstName) && m.getLastName().equals(lastName)) {
				medications = m.getMedicationList();
				break;
			}
		}	
		
		return medications;
	}
	
	public ArrayList<String> getAllergieList(String firstName, String lastName) {
        logger.info("getAllergieList(" + firstName + ", " + lastName + ")");

		ArrayList<String> allergies = null;
		
		for (MedicalRecord m : medicalRecordRepository.getMedicalRecordList()) {

			if (m.getFirstName().equals(firstName) && m.getLastName().equals(lastName)) {
				allergies = m.getAllergieList();
				break;
			}
		}	
		
		return allergies;
	}
	
	public PersonInfoDTO getPersonInfo(PersonInfoDTO personInfoDTO) {
        logger.info("getPersonInfo(" + personInfoDTO + ")");

	    String[] namePart = personInfoDTO.getName().split(" ");
	    
		String lastName = namePart[1];
		
		for (Person p : personRepository.getPersonList()) {

			if (p.getLastName().equals(lastName)) {
				
				personInfoDTO.getHealthList().add(new HealthDTO(p.getLastName(), p.getAddress(), getAge(p.getFirstName(), p.getLastName()), getMedicationList(p.getFirstName(), p.getLastName()), getAllergieList(p.getFirstName(), p.getLastName())));
			}
		}
		
		return personInfoDTO;
	}
}