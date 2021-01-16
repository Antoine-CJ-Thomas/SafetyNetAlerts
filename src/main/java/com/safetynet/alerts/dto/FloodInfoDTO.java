package com.safetynet.alerts.dto;

import java.util.ArrayList;

import com.jsoniter.annotation.JsonIgnore;

/**
 * This class stores the data of the response of a flood alert request
 */
public class FloodInfoDTO {

	private ArrayList<String> stationList = new ArrayList<String>();
	private ArrayList<HomeDTO> homeList = new ArrayList<HomeDTO>();

    @JsonIgnore
	private ArrayList<String> addressList = new ArrayList<String>();
	
	public FloodInfoDTO(ArrayList<String> stationList) {
		this.stationList = stationList;
	}

	public ArrayList<String> getStationList() {
		return stationList;
	}

	public void setHomeList(ArrayList<HomeDTO> homeList) {
		this.homeList = homeList;
	}

	public ArrayList<HomeDTO> getHomeList() {
		return homeList;
	}

	public void setAddressList(ArrayList<String> addressList) {
		this.addressList = addressList;
	}

	public ArrayList<String> getAddressList() {
		return addressList;
	}
}