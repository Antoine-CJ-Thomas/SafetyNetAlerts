package com.safetynet.alerts.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.safetynet.alerts.model.Person;

@Component
public class PersonDTO {

	private ArrayList<Person> persons = new ArrayList<Person>();

	public ArrayList<Person> getPersonList() {
		return persons;
	}

	public void addPerson(Person person) {
		persons.add(person);
	}

	public void updatePerson(Person person) {

	}

	public void removePerson(Person person) {
		persons.remove(person);
	}
}
