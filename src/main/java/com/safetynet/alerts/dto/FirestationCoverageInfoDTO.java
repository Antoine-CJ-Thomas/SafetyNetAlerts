package com.safetynet.alerts.dto;

import java.util.ArrayList;

import com.jsoniter.annotation.JsonIgnore;
import com.safetynet.alerts.model.Person;

/**
 * This class stores the data of the response of a fire station coverage request
 */
public class FirestationCoverageInfoDTO {

	private String station;
	private int childCounter;
	private int adultCounter;
	private ArrayList<ContactDTO> contactList = new ArrayList<ContactDTO>();

    @JsonIgnore
	private ArrayList<String> addressList = new ArrayList<String>();
    @JsonIgnore
	private ArrayList<Person> personList = new ArrayList<Person>();
	
	public FirestationCoverageInfoDTO(String station) {
		this.station = station;
	}

	public String getStation() {
		return station;
	}

	public int getChildCounter() {
		return childCounter;
	}

	public void increaseChildCounter() {
		childCounter++;
	}

	public int getAdultCounter() {
		return adultCounter;
	}

	public void increaseAdultCounter() {
		adultCounter++;
	}
	public void setAddressList(ArrayList<String> addressList) {
		this.addressList = addressList;
	}

	public ArrayList<String> getAddressList() {
		return addressList;
	}

	public void setPersonList(ArrayList<Person> personList) {
		this.personList = personList;
	}

	public ArrayList<Person> getPersonList() {
		return personList;
	}

	public void setContactList(ArrayList<ContactDTO> contactList) {
		this.contactList = contactList;
	}

	public ArrayList<ContactDTO> getContactList() {
		return contactList;
	}
}