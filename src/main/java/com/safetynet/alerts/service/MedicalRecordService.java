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
		medicalRecordDTO.addMedicalRecord(medicalRecord);
		return medicalRecord;
	}

	public MedicalRecord updateMedicalRecord(MedicalRecordDTO medicalRecordDTO, MedicalRecord medicalRecord) {
		medicalRecordDTO.updateMedicalRecord(medicalRecord);
		return medicalRecord;
	}

	public MedicalRecord removeMedicalRecord(MedicalRecordDTO medicalRecordDTO, MedicalRecord medicalRecord) {

		ArrayList<MedicalRecord> medicalRecordList = medicalRecordDTO.getMedicalRecordList();
		MedicalRecord deletedMedicalRecord = null;

		for (MedicalRecord m : medicalRecordList) {

			if (m.equals(medicalRecord)) {

				medicalRecordDTO.removeMedicalRecord(m);
				deletedMedicalRecord = m;
				break;
			}
		}
		return deletedMedicalRecord;
	}
}