package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhoneInfoDTOTest {

	private PhoneInfoDTO phoneInfoDTO;

    @BeforeEach
    private void beforeEach() {
    	
    	phoneInfoDTO = new PhoneInfoDTO("station");
    }

	@Test
	void test_setAndGetStation() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("station", phoneInfoDTO.getStation());
	}

	@Test
	void test_getAddressList() {

    	//GIVEN
		ArrayList<String> addressList = new ArrayList<String>();
        
    	//WHEN
		phoneInfoDTO.setAddressList(addressList);
    	
    	//THEN
        assertEquals(addressList, phoneInfoDTO.getAddressList());
	}

	@Test
	void test_getPhoneList() {

    	//GIVEN
		ArrayList<String> phoneList = new ArrayList<String>();
        
    	//WHEN
		phoneInfoDTO.setPhoneList(phoneList);
    	
    	//THEN
        assertEquals(phoneList, phoneInfoDTO.getPhoneList());
	}
}
