package com.safetynet.alerts.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.model.Person;

@SpringBootTest
class PersonTest {

	private Person person;
    
	@Test
	void test_setAndGetFirstName_equalConstantString() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
    	person = new Person(firstName, null, null, null, null, null, null);
    	
    	//THEN
        assertEquals(firstName, person.getFirstName());
	}

	@Test
	void test_setAndGetLastName_equalConstantString() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
    	person = new Person(null, lastName, null, null, null, null, null);
    	
    	//THEN
        assertEquals(lastName, person.getLastName());
	}

	@Test
	void test_setAndGetAddress_equalConstantString() {

    	//GIVEN
		String address = "address";
        
    	//WHEN
    	person = new Person(null, null, address, null, null, null, null);
    	
    	//THEN
        assertEquals(address, person.getAddress());
	}

	@Test
	void test_setAndGetCity_equalConstantString() {

    	//GIVEN
		String city = "city";
        
    	//WHEN
    	person = new Person(null, null, null, city, null, null, null);
    	
    	//THEN
        assertEquals(city, person.getCity());
	}

	@Test
	void test_setAndGetZip_equalConstantString() {

    	//GIVEN
		String zip = "zip";
        
    	//WHEN
    	person = new Person(null, null, null, null, zip, null, null);
    	
    	//THEN
        assertEquals(zip, person.getZip());
	}

	@Test
	void test_setAndGetPhone_equalConstantString() {

    	//GIVEN
		String phone = "phone";
        
    	//WHEN
    	person = new Person(null, null, null, null, null, phone, null);
    	
    	//THEN
        assertEquals(phone, person.getPhone());
	}

	@Test
	void test_setAndGetEmail_equalConstantString() {

    	//GIVEN
		String email = "email";
        
    	//WHEN
    	person = new Person(null, null, null, null, null, null, email);
    	
    	//THEN
        assertEquals(email, person.getEmail());
	}
}
