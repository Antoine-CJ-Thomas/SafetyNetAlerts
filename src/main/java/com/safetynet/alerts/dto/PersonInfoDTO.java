package com.safetynet.alerts.dto;

import java.util.ArrayList;

public class PersonInfoDTO {

	private String firstName;
	private String lastName;
	
	private ArrayList<HealthDTO> healths = new ArrayList<HealthDTO>();

	public PersonInfoDTO(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void addPersonInfo(String lastName, String address, String age, ArrayList<String> medications, ArrayList<String> allergies) {
		healths.add(new HealthDTO(lastName, address, age, medications, allergies));
	}
}