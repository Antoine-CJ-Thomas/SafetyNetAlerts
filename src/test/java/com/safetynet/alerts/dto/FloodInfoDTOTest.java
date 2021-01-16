package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.FloodInfoDTO;
import com.safetynet.alerts.dto.HomeDTO;

@SpringBootTest
class FloodInfoDTOTest {

	private FloodInfoDTO floodAlertDTO;

	private ArrayList<String> stationList = new ArrayList<String>();
	
	@Mock
	private HomeDTO homeDTO;

    @BeforeEach
    private void beforeEach() {
    	
    	floodAlertDTO = new FloodInfoDTO(stationList);
    }

	@Test
	void test_setAndGetStationList() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals(stationList, floodAlertDTO.getStationList());
	}

	@Test
	void test_addAndGetHomeList() {

    	//GIVEN
		ArrayList<HomeDTO> homeList = new ArrayList<HomeDTO>();
		
    	//WHEN
		floodAlertDTO.setHomeList(homeList);
    	
    	//THEN
        assertEquals(homeList, floodAlertDTO.getHomeList());
	}

	@Test
	void test_addAndGetAddressList() {

    	//GIVEN
		ArrayList<String> addressList = new ArrayList<String>();
        
    	//WHEN
		floodAlertDTO.setAddressList(addressList);
    	
    	//THEN
        assertEquals(addressList, floodAlertDTO.getAddressList());
	}
}
