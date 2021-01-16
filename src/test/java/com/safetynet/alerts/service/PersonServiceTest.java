package com.safetynet.alerts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.AdultDTO;
import com.safetynet.alerts.dto.ChildDTO;
import com.safetynet.alerts.dto.ChildInfoDTO;
import com.safetynet.alerts.dto.CommunityEmailInfoDTO;
import com.safetynet.alerts.dto.FireInfoDTO;
import com.safetynet.alerts.dto.FloodInfoDTO;
import com.safetynet.alerts.dto.HomeDTO;
import com.safetynet.alerts.dto.PhoneInfoDTO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.PersonService;

@SpringBootTest
class PersonServiceTest {

	private PersonService personService;

	@Mock
	private Person person, personChild, personFromList;
	@Mock
	private FireStation fireStation, fireStationFromList;
	@Mock
	private PersonRepository personRepository;
	@Mock
	private FireStationRepository fireStationRepository;
	@Mock
	private MedicalRecordRepository medicalRecordRepository;
	@Mock
	private MedicalRecordService medicalRecordService;
	@Mock
	private PhoneInfoDTO phoneInfoDTO;
	@Mock
	private CommunityEmailInfoDTO communityEmailInfoDTO;
	@Mock
	private FireInfoDTO fireInfoDTO;
	@Mock
	private FloodInfoDTO floodInfoDTO;
	@Mock
	private ChildInfoDTO childInfoDTO;

    @BeforeEach
    private void beforeEach() {

    	personService = new PersonService(personRepository, fireStationRepository, medicalRecordRepository);
    }

	@Test
	void test_getPersonList() {

    	//GIVEN
		ArrayList<Person> personList = new ArrayList<Person>();
        
    	//WHEN
		when(personRepository.getPersonList()).thenReturn(personList);
    	
    	//THEN
        assertEquals(personList, personService.getPersonList());
	}
    
	@Test
	void test_addPerson() {

    	//GIVEN
        
    	//WHEN
		when(personRepository.addPerson(any(Person.class))).thenReturn(person);
    	
    	//THEN
        assertEquals(person, personService.addPerson(person));
	}
    
	@Test
	void test_updatePerson() {

    	//GIVEN
		ArrayList<Person> personList = new ArrayList<Person>();
        
    	//WHEN
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(personFromList.getFirstName()).thenReturn("firstname");
		when(personFromList.getLastName()).thenReturn("lastname");
		when(personRepository.getPersonList()).thenReturn(personList);
		when(personRepository.updatePerson(any(Integer.class), any(Person.class))).thenReturn(person);
		personList.add(personFromList);
		
    	//THEN
        assertEquals(person, personService.updatePerson(person));
	}
	
    
	@Test
	void test_removePerson() {

    	//GIVEN
		ArrayList<Person> personList = new ArrayList<Person>();
        
    	//WHEN
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(personFromList.getFirstName()).thenReturn("firstname");
		when(personFromList.getLastName()).thenReturn("lastname");
		when(personRepository.getPersonList()).thenReturn(personList);
		when(personRepository.removePerson(any(Integer.class), any(Person.class))).thenReturn(person);
		personList.add(personFromList);
		
    	//THEN
        assertEquals(person, personService.removePerson(person));
	}
    
	@Test
	void test_getPhoneInfo() {

    	//GIVEN
		ArrayList<Person> personList = new ArrayList<Person>();
		ArrayList<FireStation> fireStationList = new ArrayList<FireStation>();
		ArrayList<String> addressList = new ArrayList<String>();
        
    	//WHEN
		when(personFromList.getAddress()).thenReturn("address");
		when(fireStationFromList.getStation()).thenReturn("1");
		when(phoneInfoDTO.getStation()).thenReturn("1");
		when(phoneInfoDTO.getAddressList()).thenReturn(addressList);
		when(fireStationFromList.getAddress()).thenReturn("address");
		when(personRepository.getPersonList()).thenReturn(personList);
		when(fireStationRepository.getFireStationList()).thenReturn(fireStationList);
		personList.add(personFromList);
		fireStationList.add(fireStationFromList);
		
    	//THEN
        assertEquals(phoneInfoDTO, personService.getPhoneInfo(phoneInfoDTO));
	}
    
	@Test
	void test_getCommunityEmailInfo() {

    	//GIVEN
		ArrayList<Person> personList = new ArrayList<Person>();
        
    	//WHEN
		when(personFromList.getCity()).thenReturn("city");
		when(personFromList.getEmail()).thenReturn("email");
		when(communityEmailInfoDTO.getCity()).thenReturn("city");
		when(personRepository.getPersonList()).thenReturn(personList);
		personList.add(personFromList);
		
    	//THEN
        assertEquals(communityEmailInfoDTO, personService.getCommunityEmailInfo(communityEmailInfoDTO));
	}
    
	@Test
	void test_getFireInfo() {

    	//GIVEN
		ArrayList<Person> personList = new ArrayList<Person>();
		ArrayList<FireStation> fireStationList = new ArrayList<FireStation>();
		ArrayList<String> medicationList = new ArrayList<String>();
        
    	//WHEN
		when(fireInfoDTO.getAddress()).thenReturn("address");
		when(personFromList.getLastName()).thenReturn("lastname");
		when(personFromList.getAddress()).thenReturn("address");
		when(personFromList.getPhone()).thenReturn("phone");
		when(fireStationFromList.getStation()).thenReturn("1");
		when(fireStationFromList.getAddress()).thenReturn("address");
		when(personRepository.getPersonList()).thenReturn(personList);
		when(fireStationRepository.getFireStationList()).thenReturn(fireStationList);
		when(medicalRecordService.getAge(any(String.class), any(String.class))).thenReturn("20");
		when(medicalRecordService.getMedicationList(any(String.class), any(String.class))).thenReturn(medicationList);
		when(medicalRecordService.getAllergieList(any(String.class), any(String.class))).thenReturn(medicationList);

		personList.add(personFromList);
		fireStationList.add(fireStationFromList);
				
    	//THEN
        assertEquals(fireInfoDTO, personService.getFireInfo(medicalRecordService, fireInfoDTO));
	}
    
	@Test
	void test_getFloodInfo() {

    	//GIVEN
		ArrayList<Person> personList = new ArrayList<Person>();
		ArrayList<FireStation> fireStationList = new ArrayList<FireStation>();
		ArrayList<String> addressList = new ArrayList<String>();
		ArrayList<String> stationList = new ArrayList<String>();
		ArrayList<HomeDTO> homeList = new ArrayList<HomeDTO>();
        
    	//WHEN
		when(personFromList.getAddress()).thenReturn("address");
		when(fireStationFromList.getStation()).thenReturn("1");
		when(fireStationFromList.getAddress()).thenReturn("address");
		when(floodInfoDTO.getStationList()).thenReturn(stationList);
		when(floodInfoDTO.getAddressList()).thenReturn(addressList);
		when(floodInfoDTO.getHomeList()).thenReturn(homeList);
		when(fireStationRepository.getFireStationList()).thenReturn(fireStationList);
		when(personRepository.getPersonList()).thenReturn(personList);
		
		personList.add(personFromList);
		fireStationList.add(fireStationFromList);
		stationList.add("1");
				
    	//THEN
        assertEquals(floodInfoDTO, personService.getFloodInfo(medicalRecordService, floodInfoDTO));
	}
    
	@Test
	void test_getChildAlertInfo() {

    	//GIVEN
		ArrayList<Person> personList = new ArrayList<Person>();
		ArrayList<ChildDTO> childList = new ArrayList<ChildDTO>();
		ArrayList<AdultDTO> adultList = new ArrayList<AdultDTO>();
        
    	//WHEN
		when(childInfoDTO.getChildList()).thenReturn(childList);
		when(childInfoDTO.getAdultList()).thenReturn(adultList);
		when(childInfoDTO.getAddress()).thenReturn("address");
		when(personChild.getFirstName()).thenReturn("childfirstname");
		when(personChild.getLastName()).thenReturn("childlastname");
		when(personChild.getAddress()).thenReturn("address");
		when(personFromList.getFirstName()).thenReturn("firstname");
		when(personFromList.getLastName()).thenReturn("lastname");
		when(personFromList.getAddress()).thenReturn("address");
		when(medicalRecordService.getAge(personFromList.getFirstName(), personFromList.getLastName())).thenReturn("20");
		when(medicalRecordService.getAge(personChild.getFirstName(), personChild.getLastName())).thenReturn("10");
		when(personRepository.getPersonList()).thenReturn(personList);
		personList.add(personFromList);
		personList.add(personChild);
				
    	//THEN
        assertEquals(childInfoDTO, personService.getChildAlertInfo(medicalRecordService, childInfoDTO));
	}
}