package com.safetynet.alerts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.ChildDTO;

@SpringBootTest
class ChildDTOTest {

	private ChildDTO childDTO;
    
	@Test
	void test_setAndGetFirstName_equalConstantString() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
    	childDTO = new ChildDTO(firstName, null, null);
    	
    	//THEN
        assertEquals(firstName, childDTO.getFirstName());
	}

	@Test
	void test_setAndGetLastName_equalConstantString() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
    	childDTO = new ChildDTO(null, lastName, null);
    	
    	//THEN
        assertEquals(lastName, childDTO.getLastName());
	}

	@Test
	void test_setAndGetAge_equalConstantString() {

    	//GIVEN
		String age = "age";
        
    	//WHEN
    	childDTO = new ChildDTO(null, null, age);
    	
    	//THEN
        assertEquals(age, childDTO.getAge());
	}
}
