package com.safetynet.alerts.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.model.FireStation;

@SpringBootTest
class FireStationTest {

	private FireStation fireStation;

	@Test
	void test_setAndGetAddress() {

    	//GIVEN
		String address = "address";
        
    	//WHEN
    	fireStation = new FireStation(address, null);
    	
    	//THEN
        assertEquals(address, fireStation.getAddress());
	}
    
	@Test
	void test_setAndGetStation() {

    	//GIVEN
		String station = "station";
        
    	//WHEN
    	fireStation = new FireStation(null, station);
    	
    	//THEN
        assertEquals(station, fireStation.getStation());
	}
}