package com.safetynet.alerts.dto;

public class ChildDTO {

	private String firstName;
	private String lastName;
	private String age;

	public ChildDTO(String firstName, String lastName, String age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAge() {
		return age;
	}
}
