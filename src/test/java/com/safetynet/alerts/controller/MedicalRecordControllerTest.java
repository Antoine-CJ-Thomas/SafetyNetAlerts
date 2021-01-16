package com.safetynet.alerts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.MedicalRecordService;

@SpringBootTest
class MedicalRecordControllerTest {
	
	private MockMvc mockMvc;
	private MvcResult mvcResult;
	   
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MedicalRecordController medicalRecordController;
	
	@Mock
	private MedicalRecord medicalRecord;
	@Mock
	private MedicalRecordService medicalRecordService;
	@Mock
	private PersonRepository personRepository;
	@Mock
	private FireStationRepository fireStationRepository;
	@Mock
	private MedicalRecordRepository medicalRecordRepository;
    	
    @BeforeEach
    private void beforeEach() {

    	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    	
    	medicalRecordController = new MedicalRecordController(personRepository, fireStationRepository, medicalRecordRepository);
        ReflectionTestUtils.setField(medicalRecordController, "medicalRecordService", medicalRecordService);
    }
   
	@Test
	void test_getMedicalRecordList() throws Exception {

    	//GIVEN
        
    	//WHEN
		mvcResult = mockMvc.perform(get("/medicalRecord")).andReturn();
		
    	//THEN
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
    
	@Test
	@Disabled
	void test_addMedicalRecord() throws Exception {
		
    	//GIVEN
        
    	//WHEN
    	
    	//THEN
	}
    
	@Test
	@Disabled
	void test_updateMedicalRecord() throws Exception {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
	}
    
	@Test
	@Disabled
	void test_removeMedicalRecord() throws Exception {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
	}
    
	@Test
	@Disabled
	void test_personInfo() throws Exception {
		
    	//GIVEN
        
    	//WHEN
    	
    	//THEN
	}
}
