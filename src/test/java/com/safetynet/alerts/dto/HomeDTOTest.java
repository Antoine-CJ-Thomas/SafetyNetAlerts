package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.HomeDTO;
import com.safetynet.alerts.dto.InhabitantDTO;

@SpringBootTest
class HomeDTOTest {

	private HomeDTO homeDTO;

	@Mock
	private InhabitantDTO inhabitantDTO;

    @BeforeEach
    private void beforeEach() {
    	
    	homeDTO = new HomeDTO("address");
    }
    
	@Test
	void test_setAndGetAddress() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("address", homeDTO.getAddress());
	}

	@Test
	void test_addAndGetInhabitantList() {

    	//GIVEN
		ArrayList<InhabitantDTO> inhabitantList = new ArrayList<InhabitantDTO>();
        
    	//WHEN
		homeDTO.setInhabitantList(inhabitantList);
    	
    	//THEN
        assertEquals(inhabitantList, homeDTO.getInhabitantList());
	}
}
