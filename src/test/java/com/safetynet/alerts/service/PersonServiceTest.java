package com.safetynet.alerts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.jsoniter.output.JsonStream;
import com.safetynet.alerts.dto.FireAlertDTO;
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
	private MedicalRecordService medicalRecordService;
	@Mock
	private Person personFromList;
	@Mock
	private Person person;
	@Mock
	private FireStation fireStation;
	@Mock
	private PersonRepository personRepository;
	@Mock
	private FireStationRepository fireStationRepository;
	@Mock
	private MedicalRecordRepository medicalRecordRepository;
	@Mock
	private FireAlertDTO fireAlertDTO;

    @BeforeEach
    private void setUpPerTest() {
    	
    	personService = new PersonService();
    }

	@Test
	void test_getPersonList() {

    	//GIVEN
		ArrayList<Person> persons = new ArrayList<Person>();
        
    	//WHEN
		when(personRepository.getPersonList()).thenReturn(persons);
    	
    	//THEN
        assertEquals(persons, personService.getPersonList(personRepository));
	}
    
	@Test
	void test_addPerson() {

    	//GIVEN
        
    	//WHEN
		when(personRepository.addPerson(any(Person.class))).thenReturn(person);
    	
    	//THEN
        assertEquals(person, personService.addPerson(personRepository, person));
	}
    
	@Test
	void test_updatePerson_withRepositoryDifferentName() {

    	//GIVEN
		ArrayList<Person> persons = new ArrayList<Person>();
        
    	//WHEN
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(personFromList.getFirstName()).thenReturn("another firstname");
		when(personFromList.getLastName()).thenReturn("another lastname");
		when(personRepository.getPersonList()).thenReturn(persons);
		when(personRepository.updatePerson(any(Integer.class), any(Person.class))).thenReturn(person);
		persons.add(personFromList);
		
    	//THEN
        assertEquals(person, personService.updatePerson(personRepository, person));
	}
    
	@Test
	void test_updatePerson_withLastDifferentLastName() {

    	//GIVEN
		ArrayList<Person> persons = new ArrayList<Person>();
        
    	//WHEN
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(personFromList.getFirstName()).thenReturn("firstname");
		when(personFromList.getLastName()).thenReturn("another lastname");
		when(personRepository.getPersonList()).thenReturn(persons);
		when(personRepository.updatePerson(any(Integer.class), any(Person.class))).thenReturn(person);
		persons.add(personFromList);
		
    	//THEN
        assertEquals(person, personService.updatePerson(personRepository, person));
	}
    
	@Test
	void test_updatePerson_withSameName() {

    	//GIVEN
		ArrayList<Person> persons = new ArrayList<Person>();
        
    	//WHEN
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(personFromList.getFirstName()).thenReturn("firstname");
		when(personFromList.getLastName()).thenReturn("lastname");
		when(personRepository.getPersonList()).thenReturn(persons);
		when(personRepository.updatePerson(any(Integer.class), any(Person.class))).thenReturn(person);
		persons.add(personFromList);
		
    	//THEN
        assertEquals(person, personService.updatePerson(personRepository, person));
	}
    
	@Test
	void test_removePerson_DifferentLastName() {

    	//GIVEN
		ArrayList<Person> persons = new ArrayList<Person>();
        
    	//WHEN
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(personFromList.getFirstName()).thenReturn("another firstname");
		when(personFromList.getLastName()).thenReturn("another lastname");
		when(personRepository.getPersonList()).thenReturn(persons);
		when(personRepository.removePerson(null)).thenReturn(person);
		persons.add(personFromList);
		
    	//THEN
        assertEquals(person, personService.removePerson(personRepository, person));
	}
    
	@Test
	void test_removePerson_withLastDifferentLastName() {

    	//GIVEN
		ArrayList<Person> persons = new ArrayList<Person>();
        
    	//WHEN
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(personFromList.getFirstName()).thenReturn("firstname");
		when(personFromList.getLastName()).thenReturn("another lastname");
		when(personRepository.getPersonList()).thenReturn(persons);
		when(personRepository.removePerson(null)).thenReturn(person);
		persons.add(personFromList);
		
    	//THEN
        assertEquals(person, personService.removePerson(personRepository, person));
	}
    
	@Test
	void test_removePerson_withSameName() {

    	//GIVEN
		ArrayList<Person> persons = new ArrayList<Person>();
        
    	//WHEN
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(personFromList.getFirstName()).thenReturn("firstname");
		when(personFromList.getLastName()).thenReturn("lastname");
		when(personRepository.getPersonList()).thenReturn(persons);
		when(personRepository.removePerson(any(Person.class))).thenReturn(person);
		persons.add(personFromList);
		
    	//THEN
        assertEquals(person, personService.removePerson(personRepository, person));
	}
    
	@Test
	void test_getPhoneList_withDifferentStationNumber() {

    	//GIVEN
		ArrayList<Person> persons = new ArrayList<Person>();
		ArrayList<String> phoneList = new ArrayList<String>();
		ArrayList<FireStation> fireStations = new ArrayList<FireStation>();
        
    	//WHEN
		when(fireStationRepository.getFireStationList()).thenReturn(fireStations);
		when(fireStation.getStation()).thenReturn("2");
		fireStations.add(fireStation);

		when(personRepository.getPersonList()).thenReturn(persons);
		when(person.getAddress()).thenReturn("address");
		persons.add(person);
		
    	//THEN
        assertEquals(phoneList, personService.getPhoneList(personRepository, fireStationRepository, "1"));
	}
    
	@Test
	void test_getPhoneList_withDifferentAdress() {

    	//GIVEN
		ArrayList<Person> persons = new ArrayList<Person>();
		ArrayList<String> phoneList = new ArrayList<String>();
		ArrayList<FireStation> fireStations = new ArrayList<FireStation>();
        
    	//WHEN
		when(fireStationRepository.getFireStationList()).thenReturn(fireStations);
		when(fireStation.getStation()).thenReturn("1");
		when(fireStation.getAddress()).thenReturn("address");
		fireStations.add(fireStation);

		when(personRepository.getPersonList()).thenReturn(persons);
		when(person.getAddress()).thenReturn("another address");
		persons.add(person);
		
		
    	//THEN
        assertEquals(phoneList, personService.getPhoneList(personRepository, fireStationRepository, "1"));
	}
    
	@Test
	void test_getPhoneList_withSameStationNumberAndAdress() {

    	//GIVEN
		ArrayList<Person> persons = new ArrayList<Person>();
		ArrayList<String> phoneList = new ArrayList<String>();
		ArrayList<FireStation> fireStations = new ArrayList<FireStation>();
        
    	//WHEN
		when(fireStationRepository.getFireStationList()).thenReturn(fireStations);
		when(fireStation.getStation()).thenReturn("1");
		when(fireStation.getAddress()).thenReturn("address");
		fireStations.add(fireStation);

		when(personRepository.getPersonList()).thenReturn(persons);
		when(person.getAddress()).thenReturn("address");
		when(person.getPhone()).thenReturn("123-456-7890");
		persons.add(person);
		
		phoneList.add("123-456-7890");
		
    	//THEN
        assertEquals(phoneList, personService.getPhoneList(personRepository, fireStationRepository, "1"));
	}
    
	@Test
	void test_getCommunityEmailList_withDifferentCity() {

    	//GIVEN
		ArrayList<Person> persons = new ArrayList<Person>();
		ArrayList<String> emailList = new ArrayList<String>();
        
    	//WHEN
		when(personRepository.getPersonList()).thenReturn(persons);
		when(person.getCity()).thenReturn("another city");
		persons.add(person);
		
    	//THEN
        assertEquals(emailList, personService.getCommunityEmailList(personRepository, "city"));
	}
    
	@Test
	void test_getCommunityEmailList_WithSameCity() {

    	//GIVEN
		ArrayList<String> emailList = new ArrayList<String>();
		ArrayList<Person> persons = new ArrayList<Person>();
        
    	//WHEN
		when(personRepository.getPersonList()).thenReturn(persons);
		when(person.getCity()).thenReturn("city");
		when(person.getEmail()).thenReturn("name@email.com");
		persons.add(person);
		
		emailList.add("name@email.com");
		
    	//THEN
        assertEquals(emailList, personService.getCommunityEmailList(personRepository, "city"));
	}
    
	@Test
	@Disabled
	void test_getFireInfo() {

    	//GIVEN
		ArrayList<Person> persons = new ArrayList<Person>();
		ArrayList<FireStation> fireStations = new ArrayList<FireStation>();
		ArrayList<String> medicationList = new ArrayList<String>();
		ArrayList<String> allergieList = new ArrayList<String>();
        
    	//WHEN
		when(personRepository.getPersonList()).thenReturn(persons);
		when(person.getFirstName()).thenReturn("firstName");
		when(person.getLastName()).thenReturn("lastName");
		when(person.getAddress()).thenReturn("address");
		persons.add(person);
		
		when(fireStationRepository.getFireStationList()).thenReturn(fireStations);
		when(fireStation.getAddress()).thenReturn("address");
		fireStations.add(fireStation);
		
		when(medicalRecordService.getAge(medicalRecordRepository, "firstName", "lastName")).thenReturn("18");
		when(medicalRecordService.getMedicationList(medicalRecordRepository, "firstName", "lastName")).thenReturn(medicationList);
		when(medicalRecordService.getAllergieList(medicalRecordRepository, "firstName", "lastName")).thenReturn(allergieList);
//		ReflectionTestUtils.setField(personService.getFireInfo(personRepository, fireStationRepository, medicalRecordRepository, "address"), "medicalRecordService", medicalRecordService);
				
    	//THEN
        assertEquals(JsonStream.serialize(fireAlertDTO), personService.getFireInfo(personRepository, fireStationRepository, medicalRecordRepository, "address"));
	}
    
	@Test
	@Disabled
	void test_getFloodInfo() {
		
	}
    
	@Test
	@Disabled
	void test_getChildAlertInfo() {
		
	}
}