package com.safetynet.alerts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.service.MedicalRecordService;

@SpringBootTest
class MedicalRecordServiceTest {

	private MedicalRecordService medicalRecordService;

	private ArrayList<MedicalRecord> medicalRecords;
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
		medicalRecords = new ArrayList<MedicalRecord>();
        
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
	void test_updateMedicalRecord_withEmptyRepository() {

    	//GIVEN
        
    	//WHEN
		when(medicalRecordRepository.updateMedicalRecord(any(Integer.class), any(MedicalRecord.class))).thenReturn(medicalRecord);
		
    	//THEN
        assertEquals(medicalRecord, medicalRecordService.updateMedicalRecord(medicalRecordRepository, medicalRecord));
	}
    
	@Test
	void test_updateMedicalRecord_withRepositoryThatContainNoCommonData() {

    	//GIVEN
		medicalRecords = new ArrayList<MedicalRecord>();
        
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
		medicalRecords = new ArrayList<MedicalRecord>();
        
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
		medicalRecords = new ArrayList<MedicalRecord>();
        
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
	void test_removeMedicalRecord_withEmptyRepository() {

    	//GIVEN
        
    	//WHEN
		when(medicalRecordRepository.removeMedicalRecord(null)).thenReturn(medicalRecord);
		
    	//THEN
        assertEquals(medicalRecord, medicalRecordService.removeMedicalRecord(medicalRecordRepository, medicalRecord));
	}
    
	@Test
	void test_removeMedicalRecord_withRepositoryThatContainNoCommonData() {

    	//GIVEN
		medicalRecords = new ArrayList<MedicalRecord>();
        
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
		medicalRecords = new ArrayList<MedicalRecord>();
        
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
		medicalRecords = new ArrayList<MedicalRecord>();
        
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
}