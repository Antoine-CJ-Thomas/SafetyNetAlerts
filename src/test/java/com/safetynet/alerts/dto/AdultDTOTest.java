package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.AdultDTO;

@SpringBootTest
class AdultDTOTest {

	private AdultDTO adultDTO;

    @BeforeEach
    private void beforeEach() {

    	adultDTO = new AdultDTO("firstName", "lastName");
    }
    
	@Test
	void test_setAndGetFirstName() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("firstName", adultDTO.getFirstName());
	}

	@Test
	void test_setAndGetLastName() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("lastName", adultDTO.getLastName());
	}
}
