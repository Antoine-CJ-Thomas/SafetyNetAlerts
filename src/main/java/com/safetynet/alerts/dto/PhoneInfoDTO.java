package com.safetynet.alerts.dto;

import java.util.ArrayList;

import com.jsoniter.annotation.JsonIgnore;

/**
 * This class stores the data of the response of a city phones request
 */
public class PhoneInfoDTO {

	private String station;
	private ArrayList<String> phoneList = new ArrayList<String>();
	
    @JsonIgnore
	private ArrayList<String> addressList = new ArrayList<String>();
	
	public PhoneInfoDTO(String station) {
		this.station = station;
	}

	public String getStation() {
		return station;
	}
	
	public void setAddressList(ArrayList<String> addressList) {
		this.addressList = addressList;
	}

	public ArrayList<String> getAddressList() {
		return addressList;
	}

	public void setPhoneList(ArrayList<String> phoneList) {
		this.phoneList = phoneList;
	}

	public ArrayList<String> getPhoneList() {
		return phoneList;
	}
}
