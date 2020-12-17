package com.safetynet.alerts.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.dto.MedicalRecordDTO;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.service.MedicalRecordService;

@RestController
public class MedicalRecordController {

	@Autowired
	private MedicalRecordService medicalRecordService;

	private static MedicalRecordDTO medicalRecordDTO;

	public MedicalRecordController(MedicalRecordDTO medicalRecordDTO) {
		MedicalRecordController.medicalRecordDTO = medicalRecordDTO;
	}

	@GetMapping("/medicalRecord")
	public ArrayList<MedicalRecord> getMedicalRecordList() {
		return medicalRecordService.getMedicalRecordList(medicalRecordDTO);
	}

	@PostMapping("/medicalRecord")
	public MedicalRecord addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return medicalRecordService.addMedicalRecord(medicalRecordDTO, medicalRecord);
	}

	@PatchMapping("/medicalRecord")
	public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return medicalRecordService.updateMedicalRecord(medicalRecordDTO, medicalRecord);
	}

	@DeleteMapping("/medicalRecord")
	public MedicalRecord removeMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return medicalRecordService.removeMedicalRecord(medicalRecordDTO, medicalRecord);
	}
}