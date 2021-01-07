package com.safetynet.alerts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.service.FireStationService;

@SpringBootTest
class FireStationServiceTest {

	private FireStationService fireStationService;

	private ArrayList<FireStation> fireStations;
	@Mock
	private FireStation fireStationFromList;	
	@Mock
	private FireStation fireStation;
	@Mock
	private FireStationRepository fireStationRepository;

    @BeforeEach
    private void setUpPerTest() {
    	
    	fireStationService = new FireStationService();
    }

	@Test
	void test_getFireStationList() {

    	//GIVEN
		fireStations = new ArrayList<FireStation>();
        
    	//WHEN
		when(fireStationRepository.getFireStationList()).thenReturn(fireStations);
    	
    	//THEN
        assertEquals(fireStations, fireStationService.getFireStationList(fireStationRepository));
	}
    
	@Test
	void test_addFireStation() {

    	//GIVEN
        
    	//WHEN
		when(fireStationRepository.addFireStation(any(FireStation.class))).thenReturn(fireStation);
    	
    	//THEN
        assertEquals(fireStation, fireStationService.addFireStation(fireStationRepository, fireStation));
	}
    
	@Test
	void test_updateFireStation_withEmptyRepository() {

    	//GIVEN
        
    	//WHEN
		when(fireStationRepository.updateFireStation(any(Integer.class), any(FireStation.class))).thenReturn(fireStation);
		
    	//THEN
        assertEquals(fireStation, fireStationService.updateFireStation(fireStationRepository, fireStation));
	}
    
	@Test
	void test_updateFireStation_withRepositoryThatContainNoCommonData() {

    	//GIVEN
		fireStations = new ArrayList<FireStation>();
        
    	//WHEN
		when(fireStation.getAddress()).thenReturn("address");
		when(fireStationFromList.getAddress()).thenReturn("another address");
		when(fireStationRepository.getFireStationList()).thenReturn(fireStations);
		when(fireStationRepository.updateFireStation(any(Integer.class), any(FireStation.class))).thenReturn(fireStation);
		fireStations.add(fireStationFromList);
		
    	//THEN
        assertEquals(fireStation, fireStationService.updateFireStation(fireStationRepository, fireStation));
	}
    
	@Test
	void test_updateFireStation_withRepositoryThatContainCommonData() {

    	//GIVEN
		fireStations = new ArrayList<FireStation>();
        
    	//WHEN
		when(fireStation.getAddress()).thenReturn("address");
		when(fireStationFromList.getAddress()).thenReturn("address");
		when(fireStationRepository.getFireStationList()).thenReturn(fireStations);
		when(fireStationRepository.updateFireStation(any(Integer.class), any(FireStation.class))).thenReturn(fireStation);
		fireStations.add(fireStationFromList);
		
    	//THEN
        assertEquals(fireStation, fireStationService.updateFireStation(fireStationRepository, fireStation));
	}
    
	@Test
	void test_removeFireStation_withEmptyRepository() {

    	//GIVEN
        
    	//WHEN
		when(fireStationRepository.removeFireStation(null)).thenReturn(fireStation);
		
    	//THEN
        assertEquals(fireStation, fireStationService.removeFireStation(fireStationRepository, fireStation));
	}
    
	@Test
	void test_removeFireStation_withRepositoryThatContainNoCommonData() {

    	//GIVEN
		fireStations = new ArrayList<FireStation>();
        
    	//WHEN
		when(fireStation.getAddress()).thenReturn("address");
		when(fireStationFromList.getAddress()).thenReturn("another address");
		when(fireStationRepository.getFireStationList()).thenReturn(fireStations);
		when(fireStationRepository.removeFireStation(null)).thenReturn(fireStation);
		fireStations.add(fireStationFromList);
		
    	//THEN
        assertEquals(fireStation, fireStationService.removeFireStation(fireStationRepository, fireStation));
	}
    
	@Test
	void test_removeFireStation_withRepositoryThatContainCommonData() {

    	//GIVEN
		fireStations = new ArrayList<FireStation>();
        
    	//WHEN
		when(fireStation.getAddress()).thenReturn("address");
		when(fireStationFromList.getAddress()).thenReturn("address");
		when(fireStationRepository.getFireStationList()).thenReturn(fireStations);
		when(fireStationRepository.removeFireStation(any(FireStation.class))).thenReturn(fireStation);
		fireStations.add(fireStation);
		
    	//THEN
        assertEquals(fireStation, fireStationService.removeFireStation(fireStationRepository, fireStation));
	}
}