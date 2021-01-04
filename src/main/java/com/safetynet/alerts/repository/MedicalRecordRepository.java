package com.safetynet.alerts.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.safetynet.alerts.model.MedicalRecord;

@Component
public class MedicalRecordRepository {

	private ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();

	public ArrayList<MedicalRecord> getMedicalRecordList() {
		return medicalRecords;
	}

	public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
		medicalRecords.add(medicalRecord);
		return medicalRecord;
	}

	public MedicalRecord updateMedicalRecord(int index, MedicalRecord medicalRecord) {
		medicalRecords.set(index, medicalRecord);
		return medicalRecord;
	}

	public MedicalRecord removeMedicalRecord(MedicalRecord medicalRecord) {
		medicalRecords.remove(medicalRecord);
		return medicalRecord;
	}
}
