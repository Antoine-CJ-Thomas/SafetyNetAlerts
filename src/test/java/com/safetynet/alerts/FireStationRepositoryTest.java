package com.safetynet.alerts;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	private FireStation fireStation;
	@Mock
	private FireStation updatedFireStation;

    @BeforeEach
    private void setUpPerTest() {
    	
    	fireStationRepository = new FireStationRepository();
    }

	@Test
	void test_addFireStation() {

    	//GIVEN
        
    	//WHEN
		fireStationRepository.addFireStation(fireStation);
    	
    	//THEN
        assertEquals(true, fireStationRepository.getFireStationList().contains(fireStation));
	}

	@Test
	void test_updateFireStation() {

    	//GIVEN
        
    	//WHEN
		fireStationRepository.addFireStation(fireStation);
		fireStationRepository.updateFireStation(fireStationRepository.getFireStationList().indexOf(fireStation), updatedFireStation);
    	
    	//THEN
        assertEquals(true, fireStationRepository.getFireStationList().contains(updatedFireStation));
	}

	@Test
	void test_removeFireStation() {

    	//GIVEN
        
    	//WHEN
		fireStationRepository.addFireStation(fireStation);
		fireStationRepository.removeFireStation(fireStation);
    	
    	//THEN
        assertEquals(false, fireStationRepository.getFireStationList().contains(fireStation));
	}
}
