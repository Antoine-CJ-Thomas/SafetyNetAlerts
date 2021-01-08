package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.InhabitantDTO;

@SpringBootTest
class InhabitantDTOTest {

	private InhabitantDTO inhabitantDTO;

	@Test
	void test_setAndGetLastName_equalConstantString() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
    	inhabitantDTO = new InhabitantDTO(lastName, null, null, null, null);
    	
    	//THEN
        assertEquals(lastName, inhabitantDTO.getLastName());
	}

	@Test
	void test_setAndGetPhone_equalConstantString() {

    	//GIVEN
		String phone = "phone";
        
    	//WHEN
    	inhabitantDTO = new InhabitantDTO(null, phone, null, null, null);
    	
    	//THEN
        assertEquals(phone, inhabitantDTO.getPhone());
	}

	@Test
	void test_setAndGetAge_equalConstantString() {

    	//GIVEN
		String age = "age";
        
    	//WHEN
    	inhabitantDTO = new InhabitantDTO(null, null, age, null, null);
    	
    	//THEN
        assertEquals(age, inhabitantDTO.getAge());
	}

	@Test
	void test_setAndGetMedications_equalConstantString() {

    	//GIVEN
		ArrayList<String> medications = new ArrayList<String>();
        
    	//WHEN
		medications.add("medication 1");
		medications.add("medication 2");
		medications.add("medication 3");
    	inhabitantDTO = new InhabitantDTO(null, null, null, medications, null);
    	
    	//THEN
        assertEquals(medications, inhabitantDTO.getMedications());
	}

	@Test
	void test_setAndGetAllergies_equalConstantString() {

    	//GIVEN
		ArrayList<String> allergies = new ArrayList<String>();
        
    	//WHEN
		allergies.add("allergie 1");
		allergies.add("allergie 2");
		allergies.add("allergie 3");
    	inhabitantDTO = new InhabitantDTO(null, null, null, null, allergies);
    	
    	//THEN
        assertEquals(allergies, inhabitantDTO.getAllergies());
	}
}
