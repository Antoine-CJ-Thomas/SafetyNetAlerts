package com.safetynet.alerts.dto;

import java.util.ArrayList;

/**
 * This class stores the data of the response of a child alert request
 */
public class ChildInfoDTO {

	private String address;
	private ArrayList<ChildDTO> childList = new ArrayList<ChildDTO>();
	private ArrayList<AdultDTO> adultList = new ArrayList<AdultDTO>();
	
	public ChildInfoDTO(String address) {
		this.address = address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setChildList(ArrayList<ChildDTO> childList) {
		this.childList = childList;
	}

	public ArrayList<ChildDTO> getChildList() {
		return childList;
	}

	public void setAdultList(ArrayList<AdultDTO> adultList) {
		this.adultList = adultList;
	}

	public ArrayList<AdultDTO> getAdultList() {
		return adultList;
	}
}