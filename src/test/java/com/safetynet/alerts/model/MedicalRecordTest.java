package com.safetynet.alerts.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.model.MedicalRecord;

@SpringBootTest
class MedicalRecordTest {

	private MedicalRecord medicalRecord;
    
	@Test
	void test_setAndGetFirstName() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
    	medicalRecord = new MedicalRecord(firstName, null, null, null, null);
    	
    	//THEN
        assertEquals(firstName, medicalRecord.getFirstName());
	}

	@Test
	void test_setAndGetLastName() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
    	medicalRecord = new MedicalRecord(null, lastName, null, null, null);
    	
    	//THEN
        assertEquals(lastName, medicalRecord.getLastName());
	}

	@Test
	void test_setAndGetBirthdate() {

    	//GIVEN
		String birthdate = "birthdate";
        
    	//WHEN
    	medicalRecord = new MedicalRecord(null, null, birthdate, null, null);
    	
    	//THEN
        assertEquals(birthdate, medicalRecord.getBirthdate());
	}

	@Test
	void test_setAndGetMedicationList() {

    	//GIVEN
		ArrayList<String> medicationList = new ArrayList<String>();
        
    	//WHEN
		medicationList.add("medication 1");
		medicationList.add("medication 2");
		medicationList.add("medication 3");
    	medicalRecord = new MedicalRecord(null, null, null, medicationList, null);
    	
    	//THEN
        assertEquals(medicationList, medicalRecord.getMedicationList());
	}

	@Test
	void test_setAndGetAllergieList() {

    	//GIVEN
		ArrayList<String> allergieList = new ArrayList<String>();
        
    	//WHEN
		allergieList.add("allergie 1");
		allergieList.add("allergie 2");
		allergieList.add("allergie 3");
    	medicalRecord = new MedicalRecord(null, null, null, null, allergieList);
    	
    	//THEN
        assertEquals(allergieList, medicalRecord.getAllergieList());
	}
}
