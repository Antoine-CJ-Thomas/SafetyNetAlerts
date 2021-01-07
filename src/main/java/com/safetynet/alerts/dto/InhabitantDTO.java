package com.safetynet.alerts.dto;

import java.util.ArrayList;

public class InhabitantDTO {

	private String lastName;
	private String phone;
	private String age;
	private ArrayList<String> medications;
	private ArrayList<String> allergies;
	
	public InhabitantDTO(String lastName, String phone, String age, ArrayList<String> medications, ArrayList<String> allergies) {
		this.lastName = lastName;
		this.phone = phone;
		this.age = age;
		this.medications = medications;
		this.allergies = allergies;
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

	public ArrayList<String> getMedications() {
		return medications;
	}

	public ArrayList<String> getAllergies() {
		return allergies;
	}
}