package com.safetynet.alerts.model;

public class FireStation {

	private String address;
	private String station;

	public FireStation(String address, String station) {

		this.address = address;
		this.station = station;
	}

	public String getAddress() {
		return address;
	}

	public String getStation() {
		return station;
	}
}