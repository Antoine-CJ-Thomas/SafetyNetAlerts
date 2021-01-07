package com.safetynet.alerts.dto;

import java.util.ArrayList;

public class ChildAlertDTO {

	private String address;
	private ArrayList<ChildDTO> childs = new ArrayList<ChildDTO>();
	private ArrayList<AdultDTO> adults = new ArrayList<AdultDTO>();
	
	public ChildAlertDTO(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public ArrayList<ChildDTO> getChilds() {
		return childs;
	}

	public ArrayList<AdultDTO> getAdults() {
		return adults;
	}
}