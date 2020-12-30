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
		return personDTO.addPerson(person);
	}

	public Person updatePerson(PersonDTO personDTO, Person person) {

		Person updatedPerson = null;
		
		for (Person p : personDTO.getPersonList()) {

			if (p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())) {
				updatedPerson = p;
				break;
			}
		}		
		return personDTO.updatePerson(personDTO.getPersonList().indexOf(updatedPerson), person);
		
	}

	public Person removePerson(PersonDTO personDTO, Person person) {

		Person deletedPerson = null;

		for (Person p : personDTO.getPersonList()) {

			if (p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())) {
				deletedPerson = p;
				break;
			}
		}
		return personDTO.removePerson(deletedPerson);
	}
}