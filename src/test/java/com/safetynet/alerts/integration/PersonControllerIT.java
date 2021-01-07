package com.safetynet.alerts.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.controller.PersonController;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;

@SpringBootTest
class PersonControllerIT {

	private PersonController personController;

	private Person person;
	private ArrayList<Person> persons;
	
	private PersonRepository personRepository;
	private FireStationRepository fireStationRepository;
	private MedicalRecordRepository medicalRecordRepository;

    @BeforeEach
    private void setUpPerTest() {
    	
    	personController = new PersonController(personRepository, fireStationRepository, medicalRecordRepository);
    }
    
	@Test
	@Disabled
	void test_getPersonList() {

    	//GIVEN
        
    	//WHEN
		
    	//THEN
        assertEquals(persons, personController.getPersonList());
	}
    
	@Test
	@Disabled
	void test_addPerson() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("", personController.addPerson(person));
	}
    
	@Test
	@Disabled
	void test_updatePerson() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("", personController.updatePerson(person));
	}
    
	@Test
	@Disabled
	void test_removePerson() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("", personController.removePerson(person));
	}
    
	@Test
	@Disabled
	void test_communityEmail() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("", personController.communityEmail(""));
	}
    
	@Test
	@Disabled
	void test_phoneAlert() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("", personController.phoneAlert(""));
	}
    
	@Test
	@Disabled
	void test_childAlert() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("", personController.childAlert(""));
	}
    
	@Test
	@Disabled
	void test_fireInfo() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("", personController.fireInfo(""));
	}
    
	@Test
	@Disabled
	void test_floodInfo() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("", personController.floodInfo(""));
	}
}
