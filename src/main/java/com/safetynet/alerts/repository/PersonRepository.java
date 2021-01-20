package com.safetynet.alerts.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.safetynet.alerts.model.Person;

/**
 * This class allows to interact with a person repository
 */
@Component
public class PersonRepository {

    private static final Logger logger = LogManager.getLogger("PersonRepository");

	private ArrayList<Person> personList = new ArrayList<Person>();

	public void setPersonList(ArrayList<Person> personList) {
        logger.info("setPersonList(" + personList + ")");
		this.personList = personList;
	}

	public ArrayList<Person> getPersonList() {
        logger.info("getPersonList()");
		return personList;
	}

	public Person addPerson(Person person) {
        logger.info("addPerson(" + person + ")");
        personList.add(person);
		return person;
	}

	public Person updatePerson(int index, Person person) {
        logger.info("updatePerson(" + index + ", " + person + ")");
        personList.set(index, person);
		return person;
	}

	public Person removePerson(int index, Person person) {
        logger.info("removePerson(" + index + ", " + person + ")");
        personList.remove(index);
		return person;
	}
}
