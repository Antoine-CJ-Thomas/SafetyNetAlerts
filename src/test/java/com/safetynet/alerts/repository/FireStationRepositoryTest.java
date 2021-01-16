package com.safetynet.alerts.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.repository.FireStationRepository;

@SpringBootTest
class FireStationRepositoryTest {

	private FireStationRepository fireStationRepository;

	@Mock
	private FireStation fireStation, updatedFireStation;

    @BeforeEach
    private void beforeEach() {
    	
    	fireStationRepository = new FireStationRepository();
    }

	@Test
	void test_getFireStationList() {

    	//GIVEN
		ArrayList<FireStation> fireStationList = new ArrayList<FireStation>();
        
    	//WHEN
		fireStationRepository.setFireStationList(fireStationList);
    	
    	//THEN
        assertEquals(fireStationList, fireStationRepository.getFireStationList());
	}

	@Test
	void test_addFireStation() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals(fireStation, fireStationRepository.addFireStation(fireStation));
	}

	@Test
	void test_updateFireStation() {

    	//GIVEN
        
    	//WHEN
		fireStationRepository.addFireStation(fireStation);

    	//THEN
        assertEquals(updatedFireStation, fireStationRepository.updateFireStation(0, updatedFireStation));
	}

	@Test
	void test_removeFireStation() {

    	//GIVEN
        
    	//WHEN
		fireStationRepository.addFireStation(fireStation);
    	
    	//THEN
        assertEquals(fireStation, fireStationRepository.removeFireStation(0, fireStation));
	}
}
