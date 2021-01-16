package com.safetynet.alerts.dto;

import java.util.ArrayList;

/**
 * This class stores the data of the response of community email request
 */
public class CommunityEmailInfoDTO {

	private String city;
	private ArrayList<String> emailList = new ArrayList<String>();

	public CommunityEmailInfoDTO(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}
	
	public void setEmailList(ArrayList<String> emailList) {
		this.emailList = emailList;
	}

	public ArrayList<String> getEmailList() {
		return emailList;
	}

}
