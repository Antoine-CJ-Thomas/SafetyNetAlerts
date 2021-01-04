package com.safetynet.alerts.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.safetynet.alerts.model.Person;

@Component
public class PersonRepository {

	private ArrayList<Person> persons = new ArrayList<Person>();

	public ArrayList<Person> getPersonList() {
		return persons;
	}

	public Person addPerson(Person person) {
		persons.add(person);
		return person;
	}

	public Person updatePerson(int index, Person person) {
		persons.set(index, person);
		return person;
	}

	public Person removePerson(Person person) {
		persons.remove(person);
		return person;
	}
}
