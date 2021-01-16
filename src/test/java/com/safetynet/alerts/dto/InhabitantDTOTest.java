package com.safetynet.alerts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.InhabitantDTO;

@SpringBootTest
class InhabitantDTOTest {

	private InhabitantDTO inhabitantDTO;
	private ArrayList<String> medicationList = new ArrayList<String>();
	private ArrayList<String> allergieList = new ArrayList<String>();

    @BeforeEach
    private void beforeEach() {

    	inhabitantDTO = new InhabitantDTO("lastName", "phone", "age", medicationList, allergieList);
    }

	@Test
	void test_setAndGetLastName() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("lastName", inhabitantDTO.getLastName());
	}

	@Test
	void test_setAndGetPhone() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("phone", inhabitantDTO.getPhone());
	}

	@Test
	void test_setAndGetAge() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals("age", inhabitantDTO.getAge());
	}

	@Test
	void test_setAndGetMedicationList() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals(medicationList, inhabitantDTO.getMedicationList());
	}

	@Test
	void test_setAndGetAllergieList() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals(allergieList, inhabitantDTO.getAllergieList());
	}
}
