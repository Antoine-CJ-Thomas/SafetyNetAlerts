package com.safetynet.alerts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.HealthDTO;
import com.safetynet.alerts.dto.PersonInfoDTO;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.MedicalRecordService;

@SpringBootTest
class MedicalRecordServiceTest {

	private MedicalRecordService medicalRecordService;

	@Mock
	private Person person;
	@Mock
	private MedicalRecord medicalRecord, medicalRecordFromList;
	@Mock
	private PersonRepository personRepository;
	@Mock
	private FireStationRepository fireStationRepository;
	@Mock
	private MedicalRecordRepository medicalRecordRepository;
	@Mock
	private PersonInfoDTO personInfoDTO;


    @BeforeEach
    private void beforeEach() {

    	medicalRecordService = new MedicalRecordService(personRepository, fireStationRepository, medicalRecordRepository);
    }

	@Test
	void test_getMedicalRecordList() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();
        
    	//WHEN
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecordList);
    	
    	//THEN
        assertEquals(medicalRecordList, medicalRecordService.getMedicalRecordList());
	}
    
	@Test
	void test_addMedicalRecord() {

    	//GIVEN
        
    	//WHEN
		when(medicalRecordRepository.addMedicalRecord(any(MedicalRecord.class))).thenReturn(medicalRecord);
    	
    	//THEN
        assertEquals(medicalRecord, medicalRecordService.addMedicalRecord(medicalRecord));
	}
    
	@Test
	void test_updateMedicalRecord() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();
        
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecordFromList.getFirstName()).thenReturn("firstname");
		when(medicalRecordFromList.getLastName()).thenReturn("lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecordList);
		when(medicalRecordRepository.updateMedicalRecord(any(Integer.class), any(MedicalRecord.class))).thenReturn(medicalRecord);
		medicalRecordList.add(medicalRecordFromList);
		
    	//THEN
        assertEquals(medicalRecord, medicalRecordService.updateMedicalRecord(medicalRecord));
	}
    
	@Test
	void test_removeMedicalRecord() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();
        
    	//WHEN
		when(medicalRecord.getFirstName()).thenReturn("firstname");
		when(medicalRecord.getLastName()).thenReturn("lastname");
		when(medicalRecordFromList.getFirstName()).thenReturn("firstname");
		when(medicalRecordFromList.getLastName()).thenReturn("lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecordList);
		when(medicalRecordRepository.removeMedicalRecord(any(Integer.class), any(MedicalRecord.class))).thenReturn(medicalRecord);
		medicalRecordList.add(medicalRecordFromList);
		
    	//THEN
        assertEquals(medicalRecord, medicalRecordService.removeMedicalRecord(medicalRecord));
	}
    
	@Test
	void test_getAge() {

    	//GIVEN
    	Date date = DateUtils.addYears(new Date(), -10);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");  
		String birthdate = dateFormat.format(date);  
		ArrayList<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();
        		
    	//WHEN
		when(medicalRecordFromList.getFirstName()).thenReturn("firstname");
		when(medicalRecordFromList.getLastName()).thenReturn("lastname");
		when(medicalRecordFromList.getBirthdate()).thenReturn(birthdate);
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecordList);
		medicalRecordList.add(medicalRecordFromList);
		
    	//THEN
        assertEquals("10", medicalRecordService.getAge("firstname", "lastname"));
	}
    
	@Test
	void test_getMedicationList() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();
		ArrayList<String> medicationList = new ArrayList<String>();
        		
    	//WHEN
		when(medicalRecordFromList.getFirstName()).thenReturn("firstname");
		when(medicalRecordFromList.getLastName()).thenReturn("lastname");
		when(medicalRecordFromList.getMedicationList()).thenReturn(medicationList);
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecordList);
		medicalRecordList.add(medicalRecordFromList);
		
    	//THEN
        assertEquals(medicationList, medicalRecordService.getMedicationList("firstname", "lastname"));
	}
    
	@Test
	void test_getAllergieList() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();
		ArrayList<String> allergieList = new ArrayList<String>();
        		
    	//WHEN
		when(medicalRecordFromList.getFirstName()).thenReturn("firstname");
		when(medicalRecordFromList.getLastName()).thenReturn("lastname");
		when(medicalRecordFromList.getAllergieList()).thenReturn(allergieList);
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecordList);
		medicalRecordList.add(medicalRecordFromList);
		
    	//THEN
        assertEquals(allergieList, medicalRecordService.getAllergieList("firstname", "lastname"));
	}
    
	@Test
	void test_getPersonInfo() {

    	//GIVEN
		ArrayList<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();
		ArrayList<HealthDTO> healthList = new ArrayList<HealthDTO>();
		ArrayList<Person> personList = new ArrayList<Person>();
		ArrayList<String> medicationList = new ArrayList<String>();
		ArrayList<String> allergieList = new ArrayList<String>();
        
    	//WHEN
		when(medicalRecordFromList.getFirstName()).thenReturn("firstname");
		when(medicalRecordFromList.getLastName()).thenReturn("lastname");
		when(medicalRecordFromList.getMedicationList()).thenReturn(medicationList);
		when(medicalRecordFromList.getAllergieList()).thenReturn(allergieList);
		when(medicalRecordFromList.getBirthdate()).thenReturn("01/01/1992");
		
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(person.getAddress()).thenReturn("address");
		
		when(medicalRecordFromList.getLastName()).thenReturn("lastname");
		when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalRecordList);

		when(personRepository.getPersonList()).thenReturn(personList);
		
		when(personInfoDTO.getName()).thenReturn("firstname lastname");
		when(personInfoDTO.getHealthList()).thenReturn(healthList);
		
		medicalRecordList.add(medicalRecordFromList);
		personList.add(person);
			
    	//THEN
        assertEquals(personInfoDTO, medicalRecordService.getPersonInfo(personInfoDTO));
	}
}