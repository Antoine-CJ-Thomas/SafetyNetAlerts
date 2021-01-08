package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.FloodAlertDTO;
import com.safetynet.alerts.dto.HomeDTO;

@SpringBootTest
class FloodAlertDTOTest {

	private FloodAlertDTO floodAlertDTO;

	@Mock
	private HomeDTO homeDTO;

    @BeforeEach
    private void setUpPerTest() {
    	
    	floodAlertDTO = new FloodAlertDTO(null);
    }

	@Test
	void test_setAndGetStation_equalConstantString() {

    	//GIVEN
		String station = "station";
        
    	//WHEN
		floodAlertDTO = new FloodAlertDTO(station);
    	
    	//THEN
        assertEquals(station, floodAlertDTO.getStation());
	}

	@Test
	void test_addAndGetHome_equalTrue() {

    	//GIVEN
        
    	//WHEN
		floodAlertDTO.getHomes().add(homeDTO);
    	
    	//THEN
        assertEquals(true, floodAlertDTO.getHomes().contains(homeDTO));
	}
}
