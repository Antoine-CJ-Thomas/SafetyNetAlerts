package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.FireAlertDTO;
import com.safetynet.alerts.dto.InhabitantDTO;

@SpringBootTest
class FireAlertDTOTest {

	private FireAlertDTO fireAlertDTO;

	@Mock
	private InhabitantDTO inhabitantDTO;

    @BeforeEach
    private void setUpPerTest() {
    	
    	fireAlertDTO = new FireAlertDTO(null, null);
    }

	@Test
	void test_setAndGetAddress_equalConstantString() {

    	//GIVEN
		String address = "address";
        
    	//WHEN
		fireAlertDTO = new FireAlertDTO(address, null);
    	
    	//THEN
        assertEquals(address, fireAlertDTO.getAddress());
	}

	@Test
	void test_setAndGetStation_equalConstantString() {

    	//GIVEN
		String station = "station";
        
    	//WHEN
		fireAlertDTO = new FireAlertDTO(null, station);
    	
    	//THEN
        assertEquals(station, fireAlertDTO.getStation());
	}

	@Test
	void test_addAndGetInhabitant_equalTrue() {

    	//GIVEN
        
    	//WHEN
		fireAlertDTO.getInhabitants().add(inhabitantDTO);
    	
    	//THEN
        assertEquals(true, fireAlertDTO.getInhabitants().contains(inhabitantDTO));
	}
}
