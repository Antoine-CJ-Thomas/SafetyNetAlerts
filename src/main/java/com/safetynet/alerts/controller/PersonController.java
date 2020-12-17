package com.safetynet.alerts.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.dto.PersonDTO;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	private static PersonDTO personDTO;

	public PersonController(PersonDTO personDTO) {
		PersonController.personDTO = personDTO;
	}

	@GetMapping("/person")
	public ArrayList<Person> getPersonList() {
		return personService.getPersonList(personDTO);
	}

	@PostMapping("/person")
	public Person addPerson(@RequestBody Person person) {
		return personService.addPerson(personDTO, person);
	}

	@PatchMapping("/person")
	public Person updatePerson(@RequestBody Person person) {
		return personService.updatePerson(personDTO, person);
	}

	@DeleteMapping("/person")
	public Person removePerson(@RequestBody Person person) {
		return personService.removePerson(personDTO, person);
	}
}