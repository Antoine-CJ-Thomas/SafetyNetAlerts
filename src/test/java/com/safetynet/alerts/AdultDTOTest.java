package com.safetynet.alerts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.AdultDTO;

@SpringBootTest
class AdultDTOTest {

	private AdultDTO adultDTO;
    
	@Test
	void test_setAndGetFirstName_equalConstantString() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
    	adultDTO = new AdultDTO(firstName, null);
    	
    	//THEN
        assertEquals(firstName, adultDTO.getFirstName());
	}

	@Test
	void test_setAndGetLastName_equalConstantString() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
    	adultDTO = new AdultDTO(null, lastName);
    	
    	//THEN
        assertEquals(lastName, adultDTO.getLastName());
	}
}
