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

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public ArrayList<HealthDTO> getHealths() {
		return healths;
	}
}