package com.safetynet.alerts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.HealthDTO;

@SpringBootTest
class HealthDTOTest {

	private HealthDTO healthDTO;

	@Test
	void test_setAndGetLastName_equalConstantString() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
    	healthDTO = new HealthDTO(lastName, null, null, null, null);
    	
    	//THEN
        assertEquals(lastName, healthDTO.getLastName());
	}

	@Test
	void test_setAndGetAddress_equalConstantString() {

    	//GIVEN
		String address = "address";
        
    	//WHEN
    	healthDTO = new HealthDTO(null, address, null, null, null);
    	
    	//THEN
        assertEquals(address, healthDTO.getAddress());
	}

	@Test
	void test_setAndGetAge_equalConstantString() {

    	//GIVEN
		String age = "age";
        
    	//WHEN
    	healthDTO = new HealthDTO(null, null, age, null, null);
    	
    	//THEN
        assertEquals(age, healthDTO.getAge());
	}

	@Test
	void test_setAndGetMedications_equalConstantString() {

    	//GIVEN
		ArrayList<String> medications = new ArrayList<String>();
        
    	//WHEN
		medications.add("medication 1");
		medications.add("medication 2");
		medications.add("medication 3");
    	healthDTO = new HealthDTO(null, null, null, medications, null);
    	
    	//THEN
        assertEquals(medications, healthDTO.getMedications());
	}

	@Test
	void test_setAndGetAllergies_equalConstantString() {

    	//GIVEN
		ArrayList<String> allergies = new ArrayList<String>();
        
    	//WHEN
		allergies.add("allergie 1");
		allergies.add("allergie 2");
		allergies.add("allergie 3");
    	healthDTO = new HealthDTO(null, null, null, null, allergies);
    	
    	//THEN
        assertEquals(allergies, healthDTO.getAllergies());
	}
}
