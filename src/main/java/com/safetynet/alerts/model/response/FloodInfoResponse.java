package com.safetynet.alerts.model.response;

import java.util.ArrayList;

public class FloodInfoResponse {

	private String station;
	private ArrayList<Home> homes = new ArrayList<Home>();
	
	public FloodInfoResponse(String station) {
		this.station = station;
	}
	
	public void addHome(String address) {
		
		homes.add(new Home(address));
	}
	
	public void addInhabitantToHome(String address, String lastName, String phone, String age, ArrayList<String> medications, ArrayList<String> allergies) {
		
		for (Home h : homes) {
			
			if (h.getAddress().equals(address)) {
				
				h.addInhabitant(lastName, phone, age, medications, allergies);
			}
		}
	}
}

class Home {
	
	private String homeAddress;
	private ArrayList<HomeInhabitant> homeInhabitants = new ArrayList<HomeInhabitant>();
	
	public Home(String address) {
		this.homeAddress = address;
	}
	
	public void addInhabitant(String lastName, String phone, String age, ArrayList<String> medications, ArrayList<String> allergies) {
		homeInhabitants.add(new HomeInhabitant(lastName, phone, age, medications, allergies));
	}
	public String getAddress() {
		return homeAddress;
	}
}

class HomeInhabitant {

	private String lastName;
	private String phone;
	private String age;
	private ArrayList<String> medications;
	private ArrayList<String> allergies;
	
	public HomeInhabitant(String lastName, String phone, String age, ArrayList<String> medications, ArrayList<String> allergies) {
		this.lastName = lastName;
		this.phone = phone;
		this.age = age;
		this.medications = medications;
		this.allergies = allergies;
	}
}