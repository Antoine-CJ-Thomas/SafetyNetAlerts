package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.ChildDTO;

@SpringBootTest
class ChildDTOTest {

	private ChildDTO childDTO;

    @BeforeEach
    private void beforeEach() {

    	childDTO = new ChildDTO("firstName", "lastName", "age");
    }
    
	@Test
	void test_setAndGetFirstName() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("firstName", childDTO.getFirstName());
	}

	@Test
	void test_setAndGetLastName() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("lastName", childDTO.getLastName());
	}

	@Test
	void test_setAndGetAge() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("age", childDTO.getAge());
	}
}
