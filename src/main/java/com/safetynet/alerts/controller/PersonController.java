package com.safetynet.alerts.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	private static PersonRepository personRepository;
	private static FireStationRepository fireStationRepository;
	private static MedicalRecordRepository medicalRecordRepository;

	public PersonController(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository) {
		PersonController.personRepository = personRepository;
		PersonController.fireStationRepository = fireStationRepository;
		PersonController.medicalRecordRepository = medicalRecordRepository;
	}

	@GetMapping("/person")
	public ArrayList<Person> getPersonList() {
		return personService.getPersonList(personRepository);
	}

	@PostMapping("/person")
	public Person addPerson(@RequestBody Person person) {
		return personService.addPerson(personRepository, person);
	}

	@PutMapping("/person")
	public Person updatePerson(@RequestBody Person person) {
		return personService.updatePerson(personRepository, person);
	}

	@DeleteMapping("/person")
	public Person removePerson(@RequestBody Person person) {
		return personService.removePerson(personRepository, person);
	}

	@GetMapping("/personInfo/{name}")
	public String personInfo(@PathVariable("name") final String name) {
		return personService.getPersonInfo(personRepository, medicalRecordRepository, name);
	}

	@GetMapping("/communityEmail/{city}")
	public ArrayList<String> communityEmail(@PathVariable("city") final String city) {
		return personService.getCommunityEmailList(personRepository, city);
	}

	@GetMapping("/phoneAlert/{firestation}")
	public ArrayList<String> phoneAlert(@PathVariable("firestation") final String firestation) {
		return personService.getPhoneList(personRepository, fireStationRepository, firestation);
	}

	@GetMapping("/childAlert/{adress}")
	public String childAlert(@PathVariable("adress") final String adress) {
		return personService.getChildAlertInfo(personRepository, medicalRecordRepository, adress);
	}

	@GetMapping("/fire/{adress}")
	public String fireInfo(@PathVariable("adress") final String adress) {
		return personService.getFireInfo(personRepository, fireStationRepository, medicalRecordRepository, adress);
	}

	@GetMapping("/flood/{firestation}")
	public String floodInfo(@PathVariable("firestation") final String firestation) {
		return personService.getFloodInfo(personRepository, fireStationRepository, medicalRecordRepository, firestation);
	}
}