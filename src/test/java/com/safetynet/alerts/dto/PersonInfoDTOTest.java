package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.HealthDTO;
import com.safetynet.alerts.dto.PersonInfoDTO;

@SpringBootTest
class PersonInfoDTOTest {

	private PersonInfoDTO personInfoDTO;

	@Mock
	private HealthDTO healthDTO;

    @BeforeEach
    private void beforeEach() {
    	
    	personInfoDTO = new PersonInfoDTO("firstName lastname");
    }
    
	@Test
	void test_setAndGetName() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("firstName lastname", personInfoDTO.getName());
	}

	@Test
	void test_addAndGetHealthList() {

    	//GIVEN
		ArrayList<HealthDTO> healthList = new ArrayList<HealthDTO>();
        
    	//WHEN
		personInfoDTO.setHealthList(healthList);
    	
    	//THEN
        assertEquals(healthList, personInfoDTO.getHealthList());
	}
}
