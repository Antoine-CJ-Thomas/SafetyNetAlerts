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
	void test_setAndGetFirstName_equalConstantString() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
    	medicalRecord = new MedicalRecord(firstName, null, null, null, null);
    	
    	//THEN
        assertEquals(firstName, medicalRecord.getFirstName());
	}

	@Test
	void test_setAndGetLastName_equalConstantString() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
    	medicalRecord = new MedicalRecord(null, lastName, null, null, null);
    	
    	//THEN
        assertEquals(lastName, medicalRecord.getLastName());
	}

	@Test
	void test_setAndGetBirthdate_equalConstantString() {

    	//GIVEN
		String birthdate = "birthdate";
        
    	//WHEN
    	medicalRecord = new MedicalRecord(null, null, birthdate, null, null);
    	
    	//THEN
        assertEquals(birthdate, medicalRecord.getBirthdate());
	}

	@Test
	void test_setAndGetMedications_equalConstantString() {

    	//GIVEN
		ArrayList<String> medications = new ArrayList<String>();
        
    	//WHEN
		medications.add("medication 1");
		medications.add("medication 2");
		medications.add("medication 3");
    	medicalRecord = new MedicalRecord(null, null, null, medications, null);
    	
    	//THEN
        assertEquals(medications, medicalRecord.getMedications());
	}

	@Test
	void test_setAndGetAllergies_equalConstantString() {

    	//GIVEN
		ArrayList<String> allergies = new ArrayList<String>();
        
    	//WHEN
		allergies.add("allergie 1");
		allergies.add("allergie 2");
		allergies.add("allergie 3");
    	medicalRecord = new MedicalRecord(null, null, null, null, allergies);
    	
    	//THEN
        assertEquals(allergies, medicalRecord.getAllergies());
	}
}
