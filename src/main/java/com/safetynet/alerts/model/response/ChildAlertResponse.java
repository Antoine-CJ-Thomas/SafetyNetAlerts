package com.safetynet.alerts.model.response;

import java.util.ArrayList;

public class ChildAlertResponse {

	private String address;

	private ArrayList<Child> childs = new ArrayList<Child>();
	private ArrayList<Adult> adults = new ArrayList<Adult>();
	
	public ChildAlertResponse(String address) {
		this.address = address;
	}
	
	public void addChild(String firstName, String lastName, String age) {
		childs.add(new Child(firstName, lastName, age));
	}
	
	public void addAdult(String firstName, String lastName) {
		adults.add(new Adult(firstName, lastName));
	}
}

class Adult {

	private String firstName;
	private String lastName;

	public Adult(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;
	}
}

class Child {

	private String firstName;
	private String lastName;
	private String age;

	public Child(String firstName, String lastName, String age) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
}