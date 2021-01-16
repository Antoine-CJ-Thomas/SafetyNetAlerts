package com.safetynet.alerts.dto;

/**
 * This class stores the data of a person contacts
 */
public class ContactDTO {

	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	
	public ContactDTO(String firstName, String lastName, String address, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}
}
