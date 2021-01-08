package com.safetynet.alerts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.FireStationService;

@SpringBootTest
class FireStationControllerTest {

	private FireStationController fireStationController;
	
	@Mock
	private FireStationService fireStationService;
	@Mock
	private FireStation fireStation;
	@Mock
	private ArrayList<FireStation> fireStations;
	@Mock
	private PersonRepository personRepository;
	@Mock
	private FireStationRepository fireStationRepository;
	@Mock
	private MedicalRecordRepository medicalRecordRepository;
	
    @BeforeEach
    private void setUpPerTest() {
    	
    	fireStationController = new FireStationController(personRepository, fireStationRepository, medicalRecordRepository);
        ReflectionTestUtils.setField(fireStationController, "fireStationService", fireStationService);
    }
    
	@Test
	void test_getFireStationList() {

    	//GIVEN
        
    	//WHEN
		when(fireStationService.getFireStationList(fireStationRepository)).thenReturn(fireStations);
		
    	//THEN
        assertEquals(fireStations, fireStationController.getFireStationList());
	}
    
	@Test
	void test_addFireStation() {

    	//GIVEN
        
    	//WHEN
		when(fireStationService.addFireStation(fireStationRepository, fireStation)).thenReturn(fireStation);
    	
    	//THEN
        assertEquals(fireStation, fireStationController.addFireStation(fireStation));
	}
    
	@Test
	void test_updateFireStation() {

    	//GIVEN
        
    	//WHEN
		when(fireStationService.updateFireStation(fireStationRepository, fireStation)).thenReturn(fireStation);
    	
    	//THEN
        assertEquals(fireStation, fireStationController.updateFireStation(fireStation));
	}
    
	@Test
	void test_removeFireStation() {

    	//GIVEN
        
    	//WHEN
		when(fireStationService.removeFireStation(fireStationRepository, fireStation)).thenReturn(fireStation);
    	
    	//THEN
        assertEquals(fireStation, fireStationController.removeFireStation(fireStation));
	}
    
	@Test
	void test_firestationCoverage() {
		
    	//GIVEN
		String firestation = new String("firestation");
		String firestationCoverage = new String("firestationCoverage");
        
    	//WHEN
		when(fireStationService.getFirestationCoverage(personRepository, fireStationRepository, medicalRecordRepository, firestation)).thenReturn(firestationCoverage);
    	
    	//THEN
        assertEquals(firestationCoverage, fireStationController.firestationCoverage(firestation));
	}
}
