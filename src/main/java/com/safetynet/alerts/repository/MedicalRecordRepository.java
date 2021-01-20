package com.safetynet.alerts.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.safetynet.alerts.model.MedicalRecord;

/**
 * This class allows to interact with a medical record repository
 */
@Component
public class MedicalRecordRepository {

    private static final Logger logger = LogManager.getLogger("MedicalRecordRepository");

	private ArrayList<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();

	public void setMedicalRecordList(ArrayList<MedicalRecord> medicalRecordList) {
        logger.info("setMedicalRecordList(" + medicalRecordList + ")");
		this.medicalRecordList = medicalRecordList;
	}

	public ArrayList<MedicalRecord> getMedicalRecordList() {
        logger.info("getMedicalRecordList()");
		return medicalRecordList;
	}

	public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
        logger.info("addMedicalRecord(" + medicalRecord + ")");
        medicalRecordList.add(medicalRecord);
		return medicalRecord;
	}

	public MedicalRecord updateMedicalRecord(int index, MedicalRecord medicalRecord) {
        logger.info("updateMedicalRecord(" + index + ", " + medicalRecord + ")");
        medicalRecordList.set(index, medicalRecord);
		return medicalRecord;
	}

	public MedicalRecord removeMedicalRecord(int index, MedicalRecord medicalRecord) {
        logger.info("removeMedicalRecord(" + index + ", " + medicalRecord + ")");
        medicalRecordList.remove(index);
		return medicalRecord;
	}
}
