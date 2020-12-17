package com.safetynet.alerts.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.safetynet.alerts.dto.PersonDTO;
import com.safetynet.alerts.model.Person;

@Service
public class PersonService {

	public ArrayList<Person> getPersonList(PersonDTO personDTO) {
		return personDTO.getPersonList();
	}

	public Person addPerson(PersonDTO personDTO, Person person) {
		personDTO.addPerson(person);
		return person;
	}

	public Person updatePerson(PersonDTO personDTO, Person person) {
		personDTO.updatePerson(person);
		return person;
	}

	public Person removePerson(PersonDTO personDTO, Person person) {

		ArrayList<Person> personList = personDTO.getPersonList();
		Person deletedPerson = null;

		for (Person p : personList) {

			if (p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())) {

				personDTO.removePerson(p);
				deletedPerson = p;
				break;
			}
		}
		return deletedPerson;
	}

	public ArrayList<String> getEmailList(PersonDTO personDTO) {

		ArrayList<Person> personList = personDTO.getPersonList();
		ArrayList<String> emailList = new ArrayList<String>();

		for (Person p : personList) {

			emailList.add(p.getEmail());
		}
		return emailList;
	}
}