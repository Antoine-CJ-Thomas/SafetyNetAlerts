package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.safetynet.alerts.dto.CommunityEmailInfoDTO;

public class CommunityEmailInfoDTOTest {

	private CommunityEmailInfoDTO communityEmailInfoDTO;

    @BeforeEach
    private void beforeEach() {
    	
    	communityEmailInfoDTO = new CommunityEmailInfoDTO("city");
    }

	@Test
	void test_setAndGetCity() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("city", communityEmailInfoDTO.getCity());
	}

	@Test
	void test_addAndGetEmailList() {

    	//GIVEN
		ArrayList<String> emailList = new ArrayList<String>();
        
    	//WHEN
		communityEmailInfoDTO.setEmailList(emailList);
    	
    	//THEN
        assertEquals(emailList, communityEmailInfoDTO.getEmailList());
	}
}
