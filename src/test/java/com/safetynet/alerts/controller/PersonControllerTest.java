package com.safetynet.alerts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.safetynet.alerts.controller.PersonController;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.PersonService;

@SpringBootTest
class PersonControllerTest {

	private PersonController personController;
	
	@Mock
	private PersonService personService;
	@Mock
	private Person person;
	@Mock
	private ArrayList<Person> persons;
	@Mock
	private PersonRepository personRepository;
	@Mock
	private FireStationRepository fireStationRepository;
	@Mock
	private MedicalRecordRepository medicalRecordRepository;
	
    @BeforeEach
    private void setUpPerTest() {
    	
    	personController = new PersonController(personRepository, fireStationRepository, medicalRecordRepository);
        ReflectionTestUtils.setField(personController, "personService", personService);
    }
    
	@Test
	void test_getPersonList() {

    	//GIVEN
        
    	//WHEN
		when(personService.getPersonList(personRepository)).thenReturn(persons);
		
    	//THEN
        assertEquals(persons, personController.getPersonList());
	}
    
	@Test
	void test_addPerson() {

    	//GIVEN
        
    	//WHEN
		when(personService.addPerson(personRepository, person)).thenReturn(person);
    	
    	//THEN
        assertEquals(person, personController.addPerson(person));
	}
    
	@Test
	void test_updatePerson() {

    	//GIVEN
        
    	//WHEN
		when(personService.updatePerson(personRepository, person)).thenReturn(person);
    	
    	//THEN
        assertEquals(person, personController.updatePerson(person));
	}
    
	@Test
	void test_removePerson() {

    	//GIVEN
        
    	//WHEN
		when(personService.removePerson(personRepository, person)).thenReturn(person);
    	
    	//THEN
        assertEquals(person, personController.removePerson(person));
	}
    
	@Test
	void test_communityEmail() {

    	//GIVEN
		String city = new String("city");
		ArrayList<String> stringArrayList = new ArrayList<String>();
        
    	//WHEN
		when(personService.getCommunityEmailList(personRepository, city)).thenReturn(stringArrayList);
    	
    	//THEN
        assertEquals(stringArrayList, personController.communityEmail(city));
	}
    
	@Test
	void test_phoneAlert() {

    	//GIVEN
		String firestation = new String("firestation");
		ArrayList<String> phoneAlert = new ArrayList<String>();
        
    	//WHEN
		when(personService.getPhoneList(personRepository, fireStationRepository, firestation)).thenReturn(phoneAlert);
    	
    	//THEN
        assertEquals(phoneAlert, personController.phoneAlert(firestation));
	}
    
	@Test
	void test_childAlert() {
		
    	//GIVEN
		String address = new String("address");
		String childAlert = new String("childAlert");
        
    	//WHEN
		when(personService.getChildAlertInfo(personRepository, medicalRecordRepository, address)).thenReturn(childAlert);
    	
    	//THEN
        assertEquals(childAlert, personController.childAlert(address));
	}
    
	@Test
	void test_fireInfo() {
		
    	//GIVEN
		String address = new String("address");
		String fireInfo = new String("fireInfo");
        
    	//WHEN
		when(personService.getFireInfo(personRepository, fireStationRepository, medicalRecordRepository, address)).thenReturn(fireInfo);
    	
    	//THEN
        assertEquals(fireInfo, personController.fireInfo(address));
	}
    
	@Test
	void test_floodInfo() {
		
    	//GIVEN
		String address = new String("address");
		String floodInfo = new String("floodInfo");
        
    	//WHEN
		when(personService.getFloodInfo(personRepository, fireStationRepository, medicalRecordRepository, address)).thenReturn(floodInfo);
    	
    	//THEN
        assertEquals(floodInfo, personController.floodInfo(address));
	}
}
