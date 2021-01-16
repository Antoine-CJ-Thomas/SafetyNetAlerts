package com.safetynet.alerts.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.MedicalRecordRepository;

@SpringBootTest
class MedicalRecordRepositoryTest {

	private MedicalRecordRepository medicalRecordRepository;

	@Mock
	private MedicalRecord medicalRecord, updatedMedicalRecord;

    @BeforeEach
    private void beforeEach() {
    	
    	medicalRecordRepository = new MedicalRecordRepository();
    }

	@Test
	void test_getMedicalRecordList() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();
        
    	//WHEN
		medicalRecordRepository.setMedicalRecordList(medicalRecordList);
    	
    	//THEN
        assertEquals(medicalRecordList, medicalRecordRepository.getMedicalRecordList());
	}

	@Test
	void test_addMedicalRecord() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals(medicalRecord, medicalRecordRepository.addMedicalRecord(medicalRecord));
	}

	@Test
	void test_updateMedicalRecord() {

    	//GIVEN
        
    	//WHEN
		medicalRecordRepository.addMedicalRecord(medicalRecord);
    	
    	//THEN
        assertEquals(updatedMedicalRecord, medicalRecordRepository.updateMedicalRecord(0, updatedMedicalRecord));
	}

	@Test
	void test_removeMedicalRecord() {

    	//GIVEN
        
    	//WHEN
		medicalRecordRepository.addMedicalRecord(medicalRecord);
    	
    	//THEN
        assertEquals(medicalRecord, medicalRecordRepository.removeMedicalRecord(0, medicalRecord));
	}
}
