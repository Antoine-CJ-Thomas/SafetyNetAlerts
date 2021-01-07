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

	public String getStation() {
		return station;
	}

	public int getChildCounter() {
		return childCounter;
	}

	public void increaseChildCounter() {
		childCounter++;
	}

	public int getAdultCounter() {
		return adultCounter;
	}

	public void increaseAdultCounter() {
		adultCounter++;
	}

	public ArrayList<ContactDTO> getContacts() {
		return contacts;
	}
}