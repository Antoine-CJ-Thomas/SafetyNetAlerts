package com.safetynet.alerts.dto;

import java.util.ArrayList;

public class HealthDTO {

	private String lastName;
	private String address;
	private String age;
	private ArrayList<String> medications;
	private ArrayList<String> allergies;
	
	public HealthDTO(String lastName, String address, String age, ArrayList<String> medications, ArrayList<String> allergies) {
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		this.medications = medications;
		this.allergies = allergies;
	}
}