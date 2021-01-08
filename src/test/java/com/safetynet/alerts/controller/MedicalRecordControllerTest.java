package com.safetynet.alerts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.MedicalRecordService;

@SpringBootTest
class MedicalRecordControllerTest {

	private MedicalRecordController medicalRecordController;
	
	@Mock
	private MedicalRecordService medicalRecordService;
	@Mock
	private MedicalRecord medicalRecord;
	@Mock
	private ArrayList<MedicalRecord> medicalRecords;
	@Mock
	private PersonRepository personRepository;
	@Mock
	private FireStationRepository fireStationRepository;
	@Mock
	private MedicalRecordRepository medicalRecordRepository;
	
    @BeforeEach
    private void setUpPerTest() {
    	
    	medicalRecordController = new MedicalRecordController(personRepository, fireStationRepository, medicalRecordRepository);
        ReflectionTestUtils.setField(medicalRecordController, "medicalRecordService", medicalRecordService);
    }
    
	@Test
	void test_getMedicalRecordList() {

    	//GIVEN
        
    	//WHEN
		when(medicalRecordService.getMedicalRecordList(medicalRecordRepository)).thenReturn(medicalRecords);
		
    	//THEN
        assertEquals(medicalRecords, medicalRecordController.getMedicalRecordList());
	}
    
	@Test
	void test_addMedicalRecord() {

    	//GIVEN
        
    	//WHEN
		when(medicalRecordService.addMedicalRecord(medicalRecordRepository, medicalRecord)).thenReturn(medicalRecord);
    	
    	//THEN
        assertEquals(medicalRecord, medicalRecordController.addMedicalRecord(medicalRecord));
	}
    
	@Test
	void test_updateMedicalRecord() {

    	//GIVEN
        
    	//WHEN
		when(medicalRecordService.updateMedicalRecord(medicalRecordRepository, medicalRecord)).thenReturn(medicalRecord);
    	
    	//THEN
        assertEquals(medicalRecord, medicalRecordController.updateMedicalRecord(medicalRecord));
	}
    
	@Test
	void test_removeMedicalRecord() {

    	//GIVEN
        
    	//WHEN
		when(medicalRecordService.removeMedicalRecord(medicalRecordRepository, medicalRecord)).thenReturn(medicalRecord);
    	
    	//THEN
        assertEquals(medicalRecord, medicalRecordController.removeMedicalRecord(medicalRecord));
	}
    
	@Test
	void test_personInfo() {
		
    	//GIVEN
		String name = new String("name");
		String personInfo = new String("personInfo");
        
    	//WHEN
		when(medicalRecordService.getPersonInfo(personRepository, medicalRecordRepository, name)).thenReturn(personInfo);
    	
    	//THEN
        assertEquals(personInfo, medicalRecordController.personInfo(name));
	}
}
