package com.safetynet.alerts.model;

import java.util.ArrayList;

/**
 * This class stores the data of a medical record
 */
public class MedicalRecord {

	private String firstName;
	private String lastName;
	private String birthdate;
	private ArrayList<String> medicationList;
	private ArrayList<String> allergieList;

	public MedicalRecord(String firstName, String lastName, String birthdate, ArrayList<String> medicationList, ArrayList<String> allergieList) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.medicationList = medicationList;
		this.allergieList = allergieList;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public ArrayList<String> getMedicationList() {
		return medicationList;
	}

	public ArrayList<String> getAllergieList() {
		return allergieList;
	}
}