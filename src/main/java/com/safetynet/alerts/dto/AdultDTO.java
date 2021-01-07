package com.safetynet.alerts.dto;

public class AdultDTO {

	private String firstName;
	private String lastName;

	public AdultDTO(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
