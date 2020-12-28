package com.safetynet.alerts.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.safetynet.alerts.dto.FireStationDTO;
import com.safetynet.alerts.dto.MedicalRecordDTO;
import com.safetynet.alerts.dto.PersonDTO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;

public class JsonFileReader {

	private String filePath;
	private PersonDTO personDTO;
	private FireStationDTO fireStationDTO;
	private MedicalRecordDTO medicalRecordDTO;

	public JsonFileReader(String filePath, PersonDTO personDTO, FireStationDTO fireStationDTO,
			MedicalRecordDTO medicalRecordDTO) {
		this.filePath = filePath;
		this.personDTO = personDTO;
		this.fireStationDTO = fireStationDTO;
		this.medicalRecordDTO = medicalRecordDTO;
	}

	public void readFile() {

		Any any = null;

		try {

			byte[] bytesFile = Files.readAllBytes(new File(filePath).toPath());
			JsonIterator iter = JsonIterator.parse(bytesFile);
			any = iter.readAny();

		} catch (IOException e) {
			e.printStackTrace();
		}

		Any personAny = any.get("persons");
		personAny.forEach(a -> personDTO.addPerson(new Person(a.get("firstName").toString(),
				a.get("lastName").toString(), a.get("address").toString(), a.get("city").toString(),
				a.get("zip").toString(), a.get("phone").toString(), a.get("email").toString())));

		Any fireStationAny = any.get("firestations");
		fireStationAny.forEach(a -> fireStationDTO
				.addFireStation(new FireStation(a.get("address").toString(), a.get("station").toString())));

		Any medicalRecordsAny = any.get("medicalrecords");
		medicalRecordsAny.forEach(a -> medicalRecordDTO
				.addMedicalRecord(new MedicalRecord(a.get("firstName").toString(), a.get("lastName").toString(),
						a.get("birthdate").toString(), extractMedications(a), extractAllergies(a))));
	}

	private ArrayList<String> extractMedications(Any any) {

		ArrayList<String> medications = new ArrayList<String>();
		Any medicationsAny = any.get("medications");
		medicationsAny.forEach(b -> medications.add(b.toString()));

		return medications;
	}

	private ArrayList<String> extractAllergies(Any any) {

		ArrayList<String> allergies = new ArrayList<String>();
		Any allergiesAny = any.get("allergies");
		allergiesAny.forEach(b -> allergies.add(b.toString()));

		return allergies;
	}
}