package com.safetynet.alerts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.safetynet.alerts.controller.FireStationController;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.FireStationService;


@SpringBootTest
class FireStationControllerTest {
	
	private MockMvc mockMvc;
	private MvcResult mvcResult;
	   
	@Autowired
   	private WebApplicationContext webApplicationContext;
	
	private FireStationController fireStationController;

	@Mock
	private FireStation fireStation;
	@Mock
	private FireStationService fireStationService;
	@Mock
	private PersonRepository personRepository;
	@Mock
	private FireStationRepository fireStationRepository;
	@Mock
	private MedicalRecordRepository medicalRecordRepository;
        	
    @BeforeEach
    private void beforeEach() {

    	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    	
    	fireStationController = new FireStationController(personRepository, fireStationRepository, medicalRecordRepository);
        ReflectionTestUtils.setField(fireStationController, "fireStationService", fireStationService);
    }
    
	@Test
	void test_getFireStationList() throws Exception {

    	//GIVEN
		
    	//WHEN
		mvcResult = mockMvc.perform(get("/firestation")).andReturn();

    	//THEN
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
	
	@Test
	void test_addFireStation() throws Exception{

    	//GIVEN
        
    	//WHEN
		mvcResult = mockMvc.perform(post("/firestation").param("address", "A").param("station", "S")).andReturn();
	
    	//THEN
		assertEquals(200, mvcResult.getResponse().getStatus());
	} 
	
	@Test
	@Disabled
	void test_updateFireStation() throws Exception {
    	
    	//GIVEN
	
    	//WHEN
    	
    	//THEN
	}
    
	@Test
	@Disabled
	void test_removeFireStation() throws Exception {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
	}
    
	@Test
	@Disabled
	void test_firestationCoverage() throws Exception {
		
    	//GIVEN
        
    	//WHEN
    	
    	//THEN
	}
}
