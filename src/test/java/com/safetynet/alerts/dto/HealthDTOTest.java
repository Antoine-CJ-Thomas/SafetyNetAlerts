package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.HealthDTO;

@SpringBootTest
class HealthDTOTest {

	private HealthDTO healthDTO;
	private ArrayList<String> medicationList = new ArrayList<String>();
	private ArrayList<String> allergieList = new ArrayList<String>();

    @BeforeEach
    private void beforeEach() {

    	healthDTO = new HealthDTO("lastName", "address", "age", medicationList, allergieList);
    }

	@Test
	void test_setAndGetLastName() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("lastName", healthDTO.getLastName());
	}

	@Test
	void test_setAndGetAddress() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("address", healthDTO.getAddress());
	}

	@Test
	void test_setAndGetAge() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("age", healthDTO.getAge());
	}

	@Test
	void test_setAndGetMedicationList() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals(medicationList, healthDTO.getMedicationList());
	}

	@Test
	void test_setAndGetAllergieList() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals(allergieList, healthDTO.getAllergieList());
	}
}
