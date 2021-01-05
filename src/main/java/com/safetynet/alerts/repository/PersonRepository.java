package com.safetynet.alerts.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.safetynet.alerts.model.Person;

@Component
public class PersonRepository {

    private static final Logger logger = LogManager.getLogger("PersonRepository");

	private ArrayList<Person> persons = new ArrayList<Person>();

	public ArrayList<Person> getPersonList() {
        logger.info("getPersonList()");
		return persons;
	}

	public Person addPerson(Person person) {
        logger.info("addPerson(" + person + ")");
		persons.add(person);
		return person;
	}

	public Person updatePerson(int index, Person person) {
        logger.info("updatePerson(" + person + ")");
		persons.set(index, person);
		return person;
	}

	public Person removePerson(Person person) {
        logger.info("removePerson(" + person + ")");
		persons.remove(person);
		return person;
	}
}
