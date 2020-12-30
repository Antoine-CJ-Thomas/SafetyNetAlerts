package com.safetynet.alerts.model.response;

import java.util.ArrayList;

public class FireInfoResponse {

	private String address;
	private String station;
	
	private ArrayList<AdressInhabitant> adressInhabitants = new ArrayList<AdressInhabitant>();
	
	public FireInfoResponse(String address, String station) {
		this.address = address;
		this.station = station;
	}
	
	public void addInhabitant(String lastName, String phone, String age, ArrayList<String> medications, ArrayList<String> allergies) {
		adressInhabitants.add(new AdressInhabitant(lastName, phone, age, medications, allergies));
	}
}

class AdressInhabitant {

	private String lastName;
	private String phone;
	private String age;
	private ArrayList<String> medications;
	private ArrayList<String> allergies;
	
	public AdressInhabitant(String lastName, String phone, String age, ArrayList<String> medications, ArrayList<String> allergies) {
		this.lastName = lastName;
		this.phone = phone;
		this.age = age;
		this.medications = medications;
		this.allergies = allergies;
	}
}