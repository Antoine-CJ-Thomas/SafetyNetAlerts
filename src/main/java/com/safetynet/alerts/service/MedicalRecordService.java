package com.safetynet.alerts.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.safetynet.alerts.dto.MedicalRecordDTO;
import com.safetynet.alerts.model.MedicalRecord;

@Service
public class MedicalRecordService {

	public ArrayList<MedicalRecord> getMedicalRecordList(MedicalRecordDTO medicalRecordDTO) {
		return medicalRecordDTO.getMedicalRecordList();
	}
	
	public String getAge(MedicalRecordDTO medicalRecordDTO, String firstName, String lastName) {

		LocalDate birthdate = null;
		LocalDate now = LocalDate.now();
	    String age = null;
		
		for (MedicalRecord m : medicalRecordDTO.getMedicalRecordList()) {

			if (m.getFirstName().equals(firstName) && m.getLastName().equals(lastName)) {
				
				birthdate = LocalDate.parse(m.getBirthdate(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			    age = String.valueOf(ChronoUnit.YEARS.between(birthdate, now));
				break;
			}
		}	
		return age;
	}
	
	public ArrayList<String> getMedicationList(MedicalRecordDTO medicalRecordDTO, String firstName, String lastName) {

		ArrayList<String> medications = null;
		
		for (MedicalRecord m : medicalRecordDTO.getMedicalRecordList()) {

			if (m.getFirstName().equals(firstName) && m.getLastName().equals(lastName)) {
				medications = m.getMedications();
				break;
			}
		}	
		return medications;
	}
	
	public ArrayList<String> getAllergieList(MedicalRecordDTO medicalRecordDTO, String firstName, String lastName) {

		ArrayList<String> allergies = null;
		
		for (MedicalRecord m : medicalRecordDTO.getMedicalRecordList()) {

			if (m.getFirstName().equals(firstName) && m.getLastName().equals(lastName)) {
				allergies = m.getAllergies();
				break;
			}
		}	
		return allergies;
	}

	public MedicalRecord addMedicalRecord(MedicalRecordDTO medicalRecordDTO, MedicalRecord medicalRecord) {
		return medicalRecordDTO.addMedicalRecord(medicalRecord);
	}

	public MedicalRecord updateMedicalRecord(MedicalRecordDTO medicalRecordDTO, MedicalRecord medicalRecord) {

		MedicalRecord updatedMedicalRecord = null;
		
		for (MedicalRecord m : medicalRecordDTO.getMedicalRecordList()) {

			if (m.getFirstName().equals(medicalRecord.getFirstName()) && m.getLastName().equals(medicalRecord.getLastName())) {
				updatedMedicalRecord = m;
				break;
			}
		}		
		return medicalRecordDTO.updateMedicalRecord(medicalRecordDTO.getMedicalRecordList().indexOf(updatedMedicalRecord), medicalRecord);
	}

	public MedicalRecord removeMedicalRecord(MedicalRecordDTO medicalRecordDTO, MedicalRecord medicalRecord) {

		MedicalRecord deletedMedicalRecord = null;

		for (MedicalRecord m : medicalRecordDTO.getMedicalRecordList()) {

			if (m.getFirstName().equals(medicalRecord.getFirstName()) && m.getLastName().equals(medicalRecord.getLastName())) {
				deletedMedicalRecord = m;
				break;
			}
		}
		return medicalRecordDTO.removeMedicalRecord(deletedMedicalRecord);
	}
}