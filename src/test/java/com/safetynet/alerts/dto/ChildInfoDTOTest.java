package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.AdultDTO;
import com.safetynet.alerts.dto.ChildDTO;

@SpringBootTest
class ChildInfoDTOTest {

	private ChildInfoDTO childAlertDTO;

	@Mock
	private ChildDTO child;
	@Mock
	private AdultDTO adult;

    @BeforeEach
    private void beforeEach() {
    	
    	childAlertDTO = new ChildInfoDTO("address");
    }

	@Test
	void test_setAndGetAddress() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("address", childAlertDTO.getAddress());
	}

	@Test
	void test_addAndGetChildList() {

    	//GIVEN
		ArrayList<ChildDTO> childList = new ArrayList<ChildDTO>();
        
    	//WHEN
		childAlertDTO.setChildList(childList);
    	
    	//THEN
        assertEquals(childList, childAlertDTO.getChildList());
	}

	@Test
	void test_addAndGetAdultList() {

    	//GIVEN
		ArrayList<AdultDTO> adultList = new ArrayList<AdultDTO>();
        
    	//WHEN
		childAlertDTO.setAdultList(adultList);
    	
    	//THEN
        assertEquals(adultList, childAlertDTO.getAdultList());
	}

}
