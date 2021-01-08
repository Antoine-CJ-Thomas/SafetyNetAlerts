package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.ContactDTO;
import com.safetynet.alerts.dto.FirestationCoverageDTO;

@SpringBootTest
class FireStationCoverageDTOTest {

	private FirestationCoverageDTO firestationCoverageDTO;

	@Mock
	private ContactDTO contactDTO;

    @BeforeEach
    private void setUpPerTest() {
    	
    	firestationCoverageDTO = new FirestationCoverageDTO(null);
    }

	@Test
	void test_setAndGetStation_equalConstantString() {

    	//GIVEN
		String station = "station";
        
    	//WHEN
		firestationCoverageDTO = new FirestationCoverageDTO(station);
    	
    	//THEN
        assertEquals(station, firestationCoverageDTO.getStation());
	}

	@Test
	void test_increaseAndGetChildCounter_equalConstantInt() {

    	//GIVEN
        
    	//WHEN
		firestationCoverageDTO.increaseChildCounter();
    	
    	//THEN
        assertEquals(1, firestationCoverageDTO.getChildCounter());
	}

	@Test
	void test_increaseAndGetAdultCounter_equalConstantInt() {

    	//GIVEN
        
    	//WHEN
		firestationCoverageDTO.increaseAdultCounter();
    	
    	//THEN
        assertEquals(1, firestationCoverageDTO.getAdultCounter());
	}

	@Test
	void test_addAndGetInhabitant_equalTrue() {

    	//GIVEN
        
    	//WHEN
		firestationCoverageDTO.getContacts().add(contactDTO);
    	
    	//THEN
        assertEquals(true, firestationCoverageDTO.getContacts().contains(contactDTO));
	}
}
