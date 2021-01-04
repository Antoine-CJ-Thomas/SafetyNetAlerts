package com.safetynet.alerts.dto;

import java.util.ArrayList;

public class ChildAlertDTO {

	private String address;

	private ArrayList<ChildDTO> childs = new ArrayList<ChildDTO>();
	private ArrayList<AdultDTO> adults = new ArrayList<AdultDTO>();
	
	public ChildAlertDTO(String address) {
		this.address = address;
	}
	
	public void addChild(String firstName, String lastName, String age) {
		childs.add(new ChildDTO(firstName, lastName, age));
	}
	
	public void addAdult(String firstName, String lastName) {
		adults.add(new AdultDTO(firstName, lastName));
	}
}