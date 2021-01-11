package com.safetynet.alerts.dto;

import java.util.ArrayList;

/**
 * This class stores the data of the response of a child alert request
 */
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