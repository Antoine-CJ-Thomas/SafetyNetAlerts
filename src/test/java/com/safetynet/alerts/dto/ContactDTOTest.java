package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.ContactDTO;

@SpringBootTest
class ContactDTOTest {

	private ContactDTO contactDTO;

    @BeforeEach
    private void beforeEach() {

    	contactDTO = new ContactDTO("firstName", "lastName", "address", "phone");
    }

	@Test
	void test_setAndGetFirstName() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("firstName", contactDTO.getFirstName());
	}

	@Test
	void test_setAndGetLastName() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("lastName", contactDTO.getLastName());
	}

	@Test
	void test_setAndGetAddress() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("address", contactDTO.getAddress());
	}

	@Test
	void test_setAndGetPhone() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("phone", contactDTO.getPhone());
	}
}
