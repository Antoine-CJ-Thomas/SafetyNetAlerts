package com.safetynet.alerts.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.safetynet.alerts.model.MedicalRecord;

@Component
public class MedicalRecordDTO {

	private ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();

	public ArrayList<MedicalRecord> getMedicalRecordList() {
		return medicalRecords;
	}

	public void addMedicalRecord(MedicalRecord medicalRecord) {
		medicalRecords.add(medicalRecord);
	}

	public void updateMedicalRecord(MedicalRecord medicalRecord) {

	}

	public void removeMedicalRecord(MedicalRecord medicalRecord) {
		medicalRecords.remove(medicalRecord);
	}
}
