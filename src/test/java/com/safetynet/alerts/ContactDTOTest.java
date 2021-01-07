package com.safetynet.alerts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.ContactDTO;

@SpringBootTest
class ContactDTOTest {

	private ContactDTO contactDTO;
    
	@Test
	void test_setAndGetFirstName_equalConstantString() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
    	contactDTO = new ContactDTO(firstName, null, null, null);
    	
    	//THEN
        assertEquals(firstName, contactDTO.getFirstName());
	}

	@Test
	void test_setAndGetLastName_equalConstantString() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
    	contactDTO = new ContactDTO(null, lastName, null, null);
    	
    	//THEN
        assertEquals(lastName, contactDTO.getLastName());
	}

	@Test
	void test_setAndGetAddress_equalConstantString() {

    	//GIVEN
		String address = "address";
        
    	//WHEN
    	contactDTO = new ContactDTO(null, null, address, null);
    	
    	//THEN
        assertEquals(address, contactDTO.getAddress());
	}

	@Test
	void test_setAndGetPhone_equalConstantString() {

    	//GIVEN
		String phone = "phone";
        
    	//WHEN
    	contactDTO = new ContactDTO(null, null, null, phone);
    	
    	//THEN
        assertEquals(phone, contactDTO.getPhone());
	}
}
