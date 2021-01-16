package com.safetynet.alerts.dto;

import java.util.ArrayList;

/**
 * This class stores the data of an inhabitant
 */
public class InhabitantDTO {

	private String lastName;
	private String phone;
	private String age;
	private ArrayList<String> medicationList;
	private ArrayList<String> allergieList;
	
	public InhabitantDTO(String lastName, String phone, String age, ArrayList<String> medicationList, ArrayList<String> allergieList) {
		this.lastName = lastName;
		this.phone = phone;
		this.age = age;
		this.medicationList = medicationList;
		this.allergieList = allergieList;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
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