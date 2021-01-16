package com.safetynet.alerts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.ContactDTO;
import com.safetynet.alerts.dto.FirestationCoverageInfoDTO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.FireStationService;

@SpringBootTest
class FireStationServiceTest {

	private FireStationService fireStationService;

	@Mock
	private Person person, personChild;
	@Mock
	private FireStation fireStation, fireStationFromList;
	@Mock
	private PersonRepository personRepository;
	@Mock
	private FireStationRepository fireStationRepository;
	@Mock
	private MedicalRecordRepository medicalRecordRepository;
	@Mock
	private FirestationCoverageInfoDTO firestationCoverageInfoDTO;
	@Mock
	private MedicalRecordService medicalRecordService;
	@Mock
	private ContactDTO contact;

    @BeforeEach
    private void beforeEach() {
    	
    	fireStationService = new FireStationService(personRepository, fireStationRepository, medicalRecordRepository);
    }

	@Test
	void test_getFireStationList() {

    	//GIVEN
		ArrayList<FireStation> fireStationList = new ArrayList<FireStation>();
        
    	//WHEN
		when(fireStationRepository.getFireStationList()).thenReturn(fireStationList);
    	
    	//THEN
        assertEquals(fireStationList, fireStationService.getFireStationList());
	}
    
	@Test
	void test_addFireStation() {

    	//GIVEN
        
    	//WHEN
		when(fireStationRepository.addFireStation(any(FireStation.class))).thenReturn(fireStation);
    	
    	//THEN
        assertEquals(fireStation, fireStationService.addFireStation(fireStation));
	}
    
	@Test
	void test_updateFireStation() {

    	//GIVEN
		ArrayList<FireStation> fireStationList = new ArrayList<FireStation>();
        
    	//WHEN
		when(fireStation.getAddress()).thenReturn("address");
		when(fireStationFromList.getAddress()).thenReturn("address");
		when(fireStationRepository.getFireStationList()).thenReturn(fireStationList);
		when(fireStationRepository.updateFireStation(any(Integer.class), any(FireStation.class))).thenReturn(fireStation);
		fireStationList.add(fireStationFromList);
		
    	//THEN
        assertEquals(fireStation, fireStationService.updateFireStation(fireStation));
	}
    
	@Test
	void test_removeFireStation() {

    	//GIVEN
		ArrayList<FireStation> fireStationList = new ArrayList<FireStation>();
        
    	//WHEN
		when(fireStation.getAddress()).thenReturn("address");
		when(fireStationFromList.getAddress()).thenReturn("address");
		when(fireStationRepository.getFireStationList()).thenReturn(fireStationList);
		when(fireStationRepository.removeFireStation(any(Integer.class), any(FireStation.class))).thenReturn(fireStation);
		fireStationList.add(fireStationFromList);
		
    	//THEN
        assertEquals(fireStation, fireStationService.removeFireStation(fireStation));
	}
    
	@Test
	void test_getFirestationCoverage() {

    	//GIVEN
		ArrayList<Person> personList = new ArrayList<Person>();
		ArrayList<Person> personListFromDTO = new ArrayList<Person>();
		ArrayList<String> addressList = new ArrayList<String>();
		ArrayList<ContactDTO> contactList = new ArrayList<ContactDTO>();
		ArrayList<FireStation> fireStationList = new ArrayList<FireStation>();
        
    	//WHEN
		when(fireStation.getStation()).thenReturn("station");
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(person.getAddress()).thenReturn("address");
		when(person.getPhone()).thenReturn("phone");
		when(personChild.getFirstName()).thenReturn("childfirstname");
		when(personChild.getLastName()).thenReturn("childlastname");
		when(personRepository.getPersonList()).thenReturn(personList);
		when(fireStationRepository.getFireStationList()).thenReturn(fireStationList);
		when(firestationCoverageInfoDTO.getStation()).thenReturn("station");
		when(firestationCoverageInfoDTO.getAddressList()).thenReturn(addressList);
		when(firestationCoverageInfoDTO.getContactList()).thenReturn(contactList);
		when(firestationCoverageInfoDTO.getPersonList()).thenReturn(personListFromDTO);
		when(medicalRecordService.getAge(person.getFirstName(), person.getLastName())).thenReturn("20");
		when(medicalRecordService.getAge(personChild.getFirstName(), personChild.getLastName())).thenReturn("10");
		personList.add(person);
		contactList.add(contact);
		addressList.add("address");
		fireStationList.add(fireStation);
		personListFromDTO.add(personChild);
			
    	//THEN
        assertEquals(firestationCoverageInfoDTO, fireStationService.getFirestationCoverage(medicalRecordService, firestationCoverageInfoDTO));
	}
}