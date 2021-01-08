package com.safetynet.alerts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.service.MedicalRecordService;

@SpringBootTest
class MedicalRecordServiceTest {

	private MedicalRecordService medicalRecordService;

	@Mock
	private MedicalRecord medicalRecordFromList;
	@Mock
	private MedicalRecord medicalRecord;
	@Mock
	private MedicalRecordRepository medicalRecordRepository;

    @BeforeEach
    private void setUpPerTest() {
    	
    	medicalRecordService = new MedicalRecordService();
    }

	@Test
	void test_getMedicalRecordList() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        
    	//WHEN
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
    	
    	//THEN
        assertEquals(medicalRecords, medicalRecordService.getMedicalRecordList(medicalRecordRepository));
	}
    
	@Test
	void test_addMedicalRecord() {

    	//GIVEN
        
    	//WHEN
		when(medicalRecordRepository.addMedicalRecord(any(MedicalRecord.class))).thenReturn(medicalRecord);
    	
    	//THEN
        assertEquals(medicalRecord, medicalRecordService.addMedicalRecord(medicalRecordRepository, medicalRecord));
	}
    
	@Test
	void test_updateMedicalRecord_withRepositoryThatContainNoCommonData() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecordFromList.getFirstName()).thenReturn("another firstname");
		when(medicalRecordFromList.getLastName()).thenReturn("another lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		when(medicalRecordRepository.updateMedicalRecord(any(Integer.class), any(MedicalRecord.class))).thenReturn(medicalRecord);
		medicalRecords.add(medicalRecordFromList);
		
    	//THEN
        assertEquals(medicalRecord, medicalRecordService.updateMedicalRecord(medicalRecordRepository, medicalRecord));
	}
    
	@Test
	void test_updateMedicalRecord_withRepositoryThatContainPartiallyCommonData() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecordFromList.getFirstName()).thenReturn("firstname");
		when(medicalRecordFromList.getLastName()).thenReturn("another lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		when(medicalRecordRepository.updateMedicalRecord(any(Integer.class), any(MedicalRecord.class))).thenReturn(medicalRecord);
		medicalRecords.add(medicalRecordFromList);
		
    	//THEN
        assertEquals(medicalRecord, medicalRecordService.updateMedicalRecord(medicalRecordRepository, medicalRecord));
	}
    
	@Test
	void test_updateMedicalRecord_withRepositoryThatContainCommonData() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecordFromList.getFirstName()).thenReturn("firstname");
		when(medicalRecordFromList.getLastName()).thenReturn("lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		when(medicalRecordRepository.updateMedicalRecord(any(Integer.class), any(MedicalRecord.class))).thenReturn(medicalRecord);
		medicalRecords.add(medicalRecordFromList);
		
    	//THEN
        assertEquals(medicalRecord, medicalRecordService.updateMedicalRecord(medicalRecordRepository, medicalRecord));
	}
    
	@Test
	void test_removeMedicalRecord_withRepositoryThatContainNoCommonData() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecordFromList.getFirstName()).thenReturn("another firstname");
		when(medicalRecordFromList.getLastName()).thenReturn("another lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		when(medicalRecordRepository.removeMedicalRecord(null)).thenReturn(medicalRecord);
		medicalRecords.add(medicalRecordFromList);
		
    	//THEN
        assertEquals(medicalRecord, medicalRecordService.removeMedicalRecord(medicalRecordRepository, medicalRecord));
	}
    
	@Test
	void test_removeMedicalRecord_withRepositoryThatContainPartiallyCommonData() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecordFromList.getFirstName()).thenReturn("firstname");
		when(medicalRecordFromList.getLastName()).thenReturn("another lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		when(medicalRecordRepository.removeMedicalRecord(null)).thenReturn(medicalRecord);
		medicalRecords.add(medicalRecordFromList);
		
    	//THEN
        assertEquals(medicalRecord, medicalRecordService.removeMedicalRecord(medicalRecordRepository, medicalRecord));
	}
    
	@Test
	void test_removeMedicalRecord_withRepositoryThatContainCommonData() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecordFromList.getFirstName()).thenReturn("firstname");
		when(medicalRecordFromList.getLastName()).thenReturn("lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		when(medicalRecordRepository.removeMedicalRecord(any(MedicalRecord.class))).thenReturn(medicalRecord);
		medicalRecords.add(medicalRecordFromList);
    	//THEN
        assertEquals(medicalRecord, medicalRecordService.removeMedicalRecord(medicalRecordRepository, medicalRecord));
	}
    
	@Test
	@Disabled
	void test_getPersonInfo() {
		
	}
    
	@Test
	void test_getAge_withDifferentFirstName() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        		
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		medicalRecords.add(medicalRecord);
		
    	//THEN
        assertEquals(null, medicalRecordService.getAge(medicalRecordRepository, "another firstname", "lastname"));
	}
    
	@Test
	void test_getAge_withDifferentLastName() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        		
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		medicalRecords.add(medicalRecord);
		
    	//THEN
        assertEquals(null, medicalRecordService.getAge(medicalRecordRepository, "firstname", "another lastname"));
	}
    
	@Test
	void test_getAge_withSameName() {

    	//GIVEN
    	Date date = DateUtils.addYears(new Date(), -10);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");  
		String birthdate = dateFormat.format(date);  
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        		
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecord.getBirthdate()).thenReturn(birthdate);
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		medicalRecords.add(medicalRecord);
		
    	//THEN
        assertEquals("10", medicalRecordService.getAge(medicalRecordRepository, "firstname", "lastname"));
	}
    
	@Test
	void test_getMedicationList_withDifferentFirstName() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        		
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		medicalRecords.add(medicalRecord);
		
    	//THEN
        assertEquals(null, medicalRecordService.getMedicationList(medicalRecordRepository, "another firstname", "lastname"));
	}
    
	@Test
	void test_getMedicationList_withDifferentLastName() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        		
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		medicalRecords.add(medicalRecord);
		
    	//THEN
        assertEquals(null, medicalRecordService.getMedicationList(medicalRecordRepository, "firstname", "another lastname"));
	}
    
	@Test
	void test_getMedicationList_withSameName() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
		ArrayList<String> medications = new ArrayList<String>();
        		
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecord.getMedications()).thenReturn(medications);
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		medicalRecords.add(medicalRecord);
		
    	//THEN
        assertEquals(medications, medicalRecordService.getMedicationList(medicalRecordRepository, "firstname", "lastname"));
	}
    
	@Test
	void test_getAllergieList_withDifferentFirstName() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        		
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		medicalRecords.add(medicalRecord);
		
    	//THEN
        assertEquals(null, medicalRecordService.getAllergieList(medicalRecordRepository, "another firstname", "lastname"));
	}
    
	@Test
	void test_getAllergieList_withDifferentLastName() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        		
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		medicalRecords.add(medicalRecord);
		
    	//THEN
        assertEquals(null, medicalRecordService.getAllergieList(medicalRecordRepository, "firstname", "another lastname"));
	}
    
	@Test
	void test_getAllergieList_withSameName() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
		ArrayList<String> Allergies = new ArrayList<String>();
        		
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecord.getAllergies()).thenReturn(Allergies);
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecords);
		medicalRecords.add(medicalRecord);
		
    	//THEN
        assertEquals(Allergies, medicalRecordService.getAllergieList(medicalRecordRepository, "firstname", "lastname"));
	}
}