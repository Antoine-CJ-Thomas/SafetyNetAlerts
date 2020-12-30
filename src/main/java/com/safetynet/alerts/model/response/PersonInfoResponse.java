package com.safetynet.alerts.model.response;

import java.util.ArrayList;

public class PersonInfoResponse {

	private String firstName;
	private String lastName;
	
	private ArrayList<PersonInfo> personInfos = new ArrayList<PersonInfo>();

	public PersonInfoResponse(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void addPersonInfo(String lastName, String address, String age, ArrayList<String> medications, ArrayList<String> allergies) {
		personInfos.add(new PersonInfo(lastName, address, age, medications, allergies));
	}
}

class PersonInfo {

	private String lastName;
	private String address;
	private String age;
	private ArrayList<String> medications;
	private ArrayList<String> allergies;
	
	public PersonInfo(String lastName, String address, String age, ArrayList<String> medications, ArrayList<String> allergies) {
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		this.medications = medications;
		this.allergies = allergies;
	}
}
