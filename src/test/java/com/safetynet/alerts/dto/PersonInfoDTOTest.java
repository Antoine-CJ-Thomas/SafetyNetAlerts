package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    private void setUpPerTest() {
    	
    	personInfoDTO = new PersonInfoDTO(null, null);
    }
    
	@Test
	void test_setAndGetFirstName_equalConstantString() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
    	personInfoDTO = new PersonInfoDTO(firstName, null);
    	
    	//THEN
        assertEquals(firstName, personInfoDTO.getFirstName());
	}

	@Test
	void test_setAndGetLastName_equalConstantString() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
    	personInfoDTO = new PersonInfoDTO(null, lastName);
    	
    	//THEN
        assertEquals(lastName, personInfoDTO.getLastName());
	}

	@Test
	void test_addAndGetHome_equalTrue() {

    	//GIVEN
        
    	//WHEN
		personInfoDTO.getHealths().add(healthDTO);
    	
    	//THEN
        assertEquals(true, personInfoDTO.getHealths().contains(healthDTO));
	}
}
