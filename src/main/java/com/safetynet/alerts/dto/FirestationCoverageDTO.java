package com.safetynet.alerts.dto;

import java.util.ArrayList;


public class FirestationCoverageDTO {

	private String station;
	
	private int childCounter;
	private int adultCounter;
	
	private ArrayList<ContactDTO> contacts = new ArrayList<ContactDTO>();
	
	public FirestationCoverageDTO(String station) {
		this.station = station;
	}

	public void addContact(String firstName, String lastName, String address, String phone) {
		contacts.add(new ContactDTO(firstName, lastName, address, phone));
	}

	public void increaseChildCounter() {
		childCounter++;
	}

	public void increaseAdultCounter() {
		adultCounter++;
	}
}