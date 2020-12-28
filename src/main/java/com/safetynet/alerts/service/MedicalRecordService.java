package com.safetynet.alerts.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.safetynet.alerts.dto.MedicalRecordDTO;
import com.safetynet.alerts.model.MedicalRecord;

@Service
public class MedicalRecordService {

	public ArrayList<MedicalRecord> getMedicalRecordList(MedicalRecordDTO medicalRecordDTO) {
		return medicalRecordDTO.getMedicalRecordList();
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