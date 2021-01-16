package com.safetynet.alerts.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.dto.ContactDTO;
import com.safetynet.alerts.dto.FirestationCoverageInfoDTO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;

/**
 * This class allows to perform actions on a repository of fire stations
 */
@Service
public class FireStationService {

    private static final Logger logger = LogManager.getLogger("FireStationService");

	private PersonRepository personRepository;
	private FireStationRepository fireStationRepository;
	private MedicalRecordRepository medicalRecordRepository;

    public FireStationService(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository) {
        logger.info("FireStationService(" + personRepository + ", " + fireStationRepository + ", " + medicalRecordRepository + ")");
        
    	this.personRepository = personRepository;
		this.fireStationRepository = fireStationRepository;
		this.medicalRecordRepository = medicalRecordRepository;
    }
    
	public ArrayList<FireStation> getFireStationList() {
        logger.info("getFireStationList()");
        
		return fireStationRepository.getFireStationList();
	}

	public FireStation addFireStation(FireStation fireStation) {
        logger.info("addFireStation(" + fireStationRepository + ", " + fireStation + ")");
        
		return fireStationRepository.addFireStation(fireStation);
	}

	public FireStation updateFireStation(FireStation fireStation) {
        logger.info("updateFireStation(" + fireStation + ")");

		int index = -1;
		
		for (FireStation f : fireStationRepository.getFireStationList()) {

			if (f.getAddress().equals(fireStation.getAddress())) {				
				index = fireStationRepository.getFireStationList().indexOf(f);
				break;
			}
		}	
		
		return fireStationRepository.updateFireStation(index, fireStation);
	}

	public FireStation removeFireStation(FireStation fireStation) {
        logger.info("removeFireStation(" + fireStation + ")");

		int index = -1;

		for (FireStation f : fireStationRepository.getFireStationList()) {

			if (f.getAddress().equals(fireStation.getAddress())) {
				index = fireStationRepository.getFireStationList().indexOf(f);
				break;
			}
		}
		
		return fireStationRepository.removeFireStation(index, fireStation);
	}

	public FirestationCoverageInfoDTO getFirestationCoverage(MedicalRecordService medicalRecordService, FirestationCoverageInfoDTO firestationCoverageInfoDTO) {
        logger.info("getPersonInfo(" + medicalRecordService + ", " + firestationCoverageInfoDTO + ")");

		for (FireStation f : fireStationRepository.getFireStationList()) {

			if (f.getStation().equals(firestationCoverageInfoDTO.getStation())) {
				
				firestationCoverageInfoDTO.getAddressList().add(f.getAddress());
			}
		}

		for (Person p : personRepository.getPersonList()) {

			if (firestationCoverageInfoDTO.getAddressList().contains(p.getAddress())) {

				firestationCoverageInfoDTO.getPersonList().add(p);
			}
		}
		
		for (Person p : firestationCoverageInfoDTO.getPersonList()) {

			firestationCoverageInfoDTO.getContactList().add(new ContactDTO(p.getFirstName(), p.getLastName(), p.getAddress(), p.getPhone()));
			
			if (Integer.parseInt(medicalRecordService.getAge(p.getFirstName(), p.getLastName())) <= 18) {
				
				firestationCoverageInfoDTO.increaseChildCounter();
			}
			
			else {

				firestationCoverageInfoDTO.increaseAdultCounter();
			}
		}
		
		return firestationCoverageInfoDTO;
	}
}