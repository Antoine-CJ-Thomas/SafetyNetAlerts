package com.safetynet.alerts.dto;

import java.util.ArrayList;

/**
 * This class stores the data of a person health
 */
public class HealthDTO {

	private String lastName;
	private String address;
	private String age;
	private ArrayList<String> medicationList;
	private ArrayList<String> allergieList;
	
	public HealthDTO(String lastName, String address, String age, ArrayList<String> medicationList, ArrayList<String> allergieList) {
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		this.medicationList = medicationList;
		this.allergieList = allergieList;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getAge() {
		return age;
	}

	public ArrayList<String> getMedicationList() {
		return medicationList;
	}

	public ArrayList<String> getAllergieList() {
		return allergieList;
	}
}