package com.safetynet.alerts.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.safetynet.alerts.model.MedicalRecord;

@Component
public class MedicalRecordRepository {

    private static final Logger logger = LogManager.getLogger("MedicalRecordRepository");

	private ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();

	public ArrayList<MedicalRecord> getMedicalRecordList() {
        logger.info("getMedicalRecordList()");
		return medicalRecords;
	}

	public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
        logger.info("addMedicalRecord(" + medicalRecord + ")");
		medicalRecords.add(medicalRecord);
		return medicalRecord;
	}

	public MedicalRecord updateMedicalRecord(int index, MedicalRecord medicalRecord) {
        logger.info("updateMedicalRecord(" + medicalRecord + ")");
		medicalRecords.set(index, medicalRecord);
		return medicalRecord;
	}

	public MedicalRecord removeMedicalRecord(MedicalRecord medicalRecord) {
        logger.info("removeMedicalRecord(" + medicalRecord + ")");
		medicalRecords.remove(medicalRecord);
		return medicalRecord;
	}
}
