package com.safetynet.alerts.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {

	public ArrayList<MedicalRecord> getMedicalRecordList(MedicalRecordRepository medicalRecordRepository) {
		return medicalRecordRepository.getMedicalRecordList();
	}
	
	public String getAge(MedicalRecordRepository medicalRecordRepository, String firstName, String lastName) {

		LocalDate birthdate = null;
		LocalDate now = LocalDate.now();
	    String age = null;
		
		for (MedicalRecord m : medicalRecordRepository.getMedicalRecordList()) {

			if (m.getFirstName().equals(firstName) && m.getLastName().equals(lastName)) {
				
				birthdate = LocalDate.parse(m.getBirthdate(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			    age = String.valueOf(ChronoUnit.YEARS.between(birthdate, now));
				break;
			}
		}	
		return age;
	}
	
	public ArrayList<String> getMedicationList(MedicalRecordRepository medicalRecordRepository, String firstName, String lastName) {

		ArrayList<String> medications = null;
		
		for (MedicalRecord m : medicalRecordRepository.getMedicalRecordList()) {

			if (m.getFirstName().equals(firstName) && m.getLastName().equals(lastName)) {
				medications = m.getMedications();
				break;
			}
		}	
		return medications;
	}
	
	public ArrayList<String> getAllergieList(MedicalRecordRepository medicalRecordRepository, String firstName, String lastName) {

		ArrayList<String> allergies = null;
		
		for (MedicalRecord m : medicalRecordRepository.getMedicalRecordList()) {

			if (m.getFirstName().equals(firstName) && m.getLastName().equals(lastName)) {
				allergies = m.getAllergies();
				break;
			}
		}	
		return allergies;
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

	public MedicalRecord addMedicalRecord(MedicalRecordRepository medicalRecordRepository, MedicalRecord medicalRecord) {
		return medicalRecordRepository.addMedicalRecord(medicalRecord);
	}

	public MedicalRecord updateMedicalRecord(MedicalRecordRepository medicalRecordRepository, MedicalRecord medicalRecord) {

		MedicalRecord updatedMedicalRecord = null;
		
		for (MedicalRecord m : medicalRecordRepository.getMedicalRecordList()) {

			if (m.getFirstName().equals(medicalRecord.getFirstName()) && m.getLastName().equals(medicalRecord.getLastName())) {
				updatedMedicalRecord = m;
				break;
			}
		}		
		return medicalRecordRepository.updateMedicalRecord(medicalRecordRepository.getMedicalRecordList().indexOf(updatedMedicalRecord), medicalRecord);
	}

	public MedicalRecord removeMedicalRecord(MedicalRecordRepository medicalRecordRepository, MedicalRecord medicalRecord) {

		MedicalRecord deletedMedicalRecord = null;

		for (MedicalRecord m : medicalRecordRepository.getMedicalRecordList()) {

			if (m.getFirstName().equals(medicalRecord.getFirstName()) && m.getLastName().equals(medicalRecord.getLastName())) {
				deletedMedicalRecord = m;
				break;
			}
		}
		return medicalRecordRepository.removeMedicalRecord(deletedMedicalRecord);
	}
}