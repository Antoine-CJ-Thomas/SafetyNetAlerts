package com.safetynet.alerts.dto;

import java.util.ArrayList;

/**
 * This class stores the data of the response of a person info request
 */
public class PersonInfoDTO {

	private String name;
	private ArrayList<HealthDTO> healthList = new ArrayList<HealthDTO>();

	public PersonInfoDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setHealthList(ArrayList<HealthDTO> healthList) {
		this.healthList = healthList;
	}

	public ArrayList<HealthDTO> getHealthList() {
		return healthList;
	}
}