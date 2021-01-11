package com.safetynet.alerts.model;

import java.util.ArrayList;

/**
 * This class stores the data of a medical record
 */
public class MedicalRecord {

	private String firstName;
	private String lastName;
	private String birthdate;
	private ArrayList<String> medications;
	private ArrayList<String> allergies;

	public MedicalRecord(String firstName, String lastName, String birthdate, ArrayList<String> medications, ArrayList<String> allergies) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
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

	public ArrayList<String> getMedications() {
		return medications;
	}

	public ArrayList<String> getAllergies() {
		return allergies;
	}
}