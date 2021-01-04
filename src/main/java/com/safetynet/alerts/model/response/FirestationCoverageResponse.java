package com.safetynet.alerts.model.response;

import java.util.ArrayList;


public class FirestationCoverageResponse {

	private String station;
	
	private int childCounter;
	private int adultCounter;
	
	private ArrayList<CoveredPerson> coveredPersons = new ArrayList<CoveredPerson>();
	
	public FirestationCoverageResponse(String station) {
		this.station = station;
	}

	public void addPerson(String firstName, String lastName, String address, String phone) {
		
		coveredPersons.add(new CoveredPerson(firstName, lastName, address, phone));
	}

	public void increaseChildCounter() {
		childCounter++;
	}

	public void increaseAdultCounter() {
		adultCounter++;
	}
}

class CoveredPerson {

	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	
	public CoveredPerson(String firstName, String lastName, String address, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = lastName;
	}
}