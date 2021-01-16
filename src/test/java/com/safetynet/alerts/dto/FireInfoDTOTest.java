package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.FireInfoDTO;
import com.safetynet.alerts.dto.InhabitantDTO;

@SpringBootTest
class FireInfoDTOTest {

	private FireInfoDTO fireAlertDTO;

	@Mock
	private InhabitantDTO inhabitantDTO;

    @BeforeEach
    private void beforeEach() {
    	
    	fireAlertDTO = new FireInfoDTO("address");
    }

	@Test
	void test_setAndGetAddress() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("address", fireAlertDTO.getAddress());
	}

	@Test
	void test_setAndGetStation() {

    	//GIVEN
		String station = "station";
        
    	//WHEN
		fireAlertDTO.setStation(station);
    	
    	//THEN
        assertEquals(station, fireAlertDTO.getStation());
	}

	@Test
	void test_addAndGetInhabitantList() {

    	//GIVEN
		ArrayList<InhabitantDTO> inhabitantList = new ArrayList<InhabitantDTO>();
        
    	//WHEN
		fireAlertDTO.setInhabitantList(inhabitantList);
    	
    	//THEN
        assertEquals(inhabitantList, fireAlertDTO.getInhabitantList());
	}
}
