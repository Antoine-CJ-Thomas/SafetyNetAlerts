package com.safetynet.alerts.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	private MedicalRecord medicalRecord;
	@Mock
	private MedicalRecord updatedMedicalRecord;

    @BeforeEach
    private void setUpPerTest() {
    	
    	medicalRecordRepository = new MedicalRecordRepository();
    }

	@Test
	void test_addFireStation() {

    	//GIVEN
        
    	//WHEN
		medicalRecordRepository.addMedicalRecord(medicalRecord);
    	
    	//THEN
        assertEquals(true, medicalRecordRepository.getMedicalRecordList().contains(medicalRecord));
	}

	@Test
	void test_updateFireStation() {

    	//GIVEN
        
    	//WHEN
		medicalRecordRepository.addMedicalRecord(medicalRecord);
		medicalRecordRepository.updateMedicalRecord(medicalRecordRepository.getMedicalRecordList().indexOf(medicalRecord), updatedMedicalRecord);
    	
    	//THEN
        assertEquals(true, medicalRecordRepository.getMedicalRecordList().contains(updatedMedicalRecord));
	}

	@Test
	void test_removeFireStation() {

    	//GIVEN
        
    	//WHEN
		medicalRecordRepository.addMedicalRecord(medicalRecord);
		medicalRecordRepository.removeMedicalRecord(medicalRecord);
    	
    	//THEN
        assertEquals(false, medicalRecordRepository.getMedicalRecordList().contains(medicalRecord));
	}
}
