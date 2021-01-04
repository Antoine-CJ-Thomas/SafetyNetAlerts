package com.safetynet.alerts.dto;

class ContactDTO {

	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	
	public ContactDTO(String firstName, String lastName, String address, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = lastName;
	}
}
