package com.safetynet.alerts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.safetynet.alerts.controller.PersonController;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.PersonService;

@SpringBootTest
class PersonControllerTest {
	
	private MockMvc mockMvc;
	private MvcResult mvcResult;
	   
	@Autowired
   	private WebApplicationContext webApplicationContext;

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
    private void beforeEach() {

    	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
    	personController = new PersonController(personRepository, fireStationRepository, medicalRecordRepository);
        ReflectionTestUtils.setField(personController, "personService", personService);
    }
   
	@Test
	void test_getPersonList() throws Exception {

    	//GIVEN
        
    	//WHEN
		mvcResult = mockMvc.perform(get("/person")).andReturn();
		
    	//THEN
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
    
	@Test
	@Disabled
	void test_addPerson() throws Exception{
		
    	//GIVEN
        
    	//WHEN
    	
    	//THEN
	}
    
	@Test
	@Disabled
	void test_updatePerson() throws Exception {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
	}
    
	@Test
	@Disabled
	void test_removePerson() throws Exception {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
	}
    
	@Test
	@Disabled
	void test_communityEmail() throws Exception {
		
    	//GIVEN
        
    	//WHEN
    	
    	//THEN
	}
    
	@Test
	@Disabled
	void test_phoneAlert() throws Exception {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
	}
    
	@Test
	@Disabled
	void test_childAlert() throws Exception {
		
    	//GIVEN
        
    	//WHEN
    	
    	//THEN
	}
    
	@Test
	@Disabled
	void test_fireInfo() throws Exception {
		
    	//GIVEN
        
    	//WHEN
    	
    	//THEN
	}
    
	@Test
	@Disabled
	void test_floodInfo() throws Exception {
		
    	//GIVEN
        
    	//WHEN
    	
    	//THEN
	}
}
