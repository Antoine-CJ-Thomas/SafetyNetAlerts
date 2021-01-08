package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.AdultDTO;
import com.safetynet.alerts.dto.ChildAlertDTO;
import com.safetynet.alerts.dto.ChildDTO;

@SpringBootTest
class ChildAlertDTOTest {

	private ChildAlertDTO childAlertDTO;

	@Mock
	private ChildDTO child;
	
	@Mock
	private AdultDTO adult;

    @BeforeEach
    private void setUpPerTest() {
    	
    	childAlertDTO = new ChildAlertDTO(null);
    }

	@Test
	void test_setAndGetAddress_equalConstantString() {

    	//GIVEN
		String address = "address";
        
    	//WHEN
		childAlertDTO = new ChildAlertDTO(address);
    	
    	//THEN
        assertEquals(address, childAlertDTO.getAddress());
	}

	@Test
	void test_addAndGetChild_equalTrue() {

    	//GIVEN
        
    	//WHEN
		childAlertDTO.getChilds().add(child);
    	
    	//THEN
        assertEquals(true, childAlertDTO.getChilds().contains(child));
	}

	@Test
	void test_addAndGetAdult_equalTrue() {

    	//GIVEN
        
    	//WHEN
		childAlertDTO.getAdults().add(adult);
    	
    	//THEN
        assertEquals(true, childAlertDTO.getAdults().contains(adult));
	}

}
