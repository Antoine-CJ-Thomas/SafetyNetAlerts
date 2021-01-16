package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.ContactDTO;
import com.safetynet.alerts.dto.FirestationCoverageInfoDTO;
import com.safetynet.alerts.model.Person;

@SpringBootTest
class FireStationCoverageInfoDTOTest {

	private FirestationCoverageInfoDTO firestationCoverageDTO;

	@Mock
	private Person person;
	@Mock
	private ContactDTO contactDTO;

    @BeforeEach
    private void beforeEach() {
    	
    	firestationCoverageDTO = new FirestationCoverageInfoDTO("station");
    }

	@Test
	void test_setAndGetStation() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("station", firestationCoverageDTO.getStation());
	}

	@Test
	void test_increaseAndGetChildCounter() {

    	//GIVEN
        
    	//WHEN
		firestationCoverageDTO.increaseChildCounter();
    	
    	//THEN
        assertEquals(1, firestationCoverageDTO.getChildCounter());
	}

	@Test
	void test_increaseAndGetAdultCounter() {

    	//GIVEN
        
    	//WHEN
		firestationCoverageDTO.increaseAdultCounter();
    	
    	//THEN
        assertEquals(1, firestationCoverageDTO.getAdultCounter());
	}

	@Test
	void test_addAndGetAddressList() {

    	//GIVEN
		ArrayList<String> addressList = new ArrayList<String>();
        
    	//WHEN
		firestationCoverageDTO.setAddressList(addressList);
    	
    	//THEN
        assertEquals(addressList, firestationCoverageDTO.getAddressList());
	}

	@Test
	void test_addAndGetPersonList() {

    	//GIVEN
		ArrayList<Person> personList = new ArrayList<Person>();
        
    	//WHEN
		firestationCoverageDTO.setPersonList(personList);
    	
    	//THEN
        assertEquals(personList, firestationCoverageDTO.getPersonList());
	}

	@Test
	void test_addAndGetContactList() {

    	//GIVEN
		ArrayList<ContactDTO> contactList = new ArrayList<ContactDTO>();
        
    	//WHEN
		firestationCoverageDTO.setContactList(contactList);
    	
    	//THEN
        assertEquals(contactList, firestationCoverageDTO.getContactList());
	}
}
