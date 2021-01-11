package com.safetynet.alerts.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;

/**
 * This class allows to extract data from a JSON file, and store them in different repositories
 */
public class JsonFileReader {

    private static final Logger logger = LogManager.getLogger("JsonFileReader");

	public void readFile(String filePath, PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository) {
        logger.info("readFile(" + filePath + ", " + personRepository + ", " + fireStationRepository + ", " + medicalRecordRepository + ", " + ")");

		Any any = null;

		try {

			byte[] bytesFile = Files.readAllBytes(new File(filePath).toPath());
			JsonIterator iter = JsonIterator.parse(bytesFile);
			any = iter.readAny();

		} catch (IOException e) {
	        logger.error("readFile(" + e + ")");
			e.printStackTrace();
		}

		Any personAny = any.get("persons");
		personAny.forEach(a -> personRepository.addPerson(new Person(a.get("firstName").toString(),
				a.get("lastName").toString(), a.get("address").toString(), a.get("city").toString(),
				a.get("zip").toString(), a.get("phone").toString(), a.get("email").toString())));

		Any fireStationAny = any.get("firestations");
		fireStationAny.forEach(a -> fireStationRepository
				.addFireStation(new FireStation(a.get("address").toString(), a.get("station").toString())));

		Any medicalRecordsAny = any.get("medicalrecords");
		medicalRecordsAny.forEach(a -> medicalRecordRepository
				.addMedicalRecord(new MedicalRecord(a.get("firstName").toString(), a.get("lastName").toString(),
						a.get("birthdate").toString(), extractMedications(a), extractAllergies(a))));
	}

	private ArrayList<String> extractMedications(Any any) {
        logger.info("extractMedications(" + any + ")");

		ArrayList<String> medications = new ArrayList<String>();
		Any medicationsAny = any.get("medications");
		medicationsAny.forEach(b -> medications.add(b.toString()));

		return medications;
	}

	private ArrayList<String> extractAllergies(Any any) {
        logger.info("extractAllergies(" + any + ")");

		ArrayList<String> allergies = new ArrayList<String>();
		Any allergiesAny = any.get("allergies");
		allergiesAny.forEach(b -> allergies.add(b.toString()));

		return allergies;
	}
}