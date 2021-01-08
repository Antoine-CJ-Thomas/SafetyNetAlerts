package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    private void setUpPerTest() {
    	
    	homeDTO = new HomeDTO(null);
    }
    
	@Test
	void test_setAndGetAddress_equalConstantString() {

    	//GIVEN
		String address = "address";
        
    	//WHEN
		homeDTO = new HomeDTO(address);
    	
    	//THEN
        assertEquals(address, homeDTO.getAddress());
	}

	@Test
	void test_addAndGetHome_equalTrue() {

    	//GIVEN
        
    	//WHEN
		homeDTO.getInhabitants().add(inhabitantDTO);
    	
    	//THEN
        assertEquals(true, homeDTO.getInhabitants().contains(inhabitantDTO));
	}
}
