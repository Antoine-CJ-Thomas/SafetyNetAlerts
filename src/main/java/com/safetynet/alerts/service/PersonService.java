package com.safetynet.alerts.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Person;


@Service
public class PersonService {

	public ArrayList<String> getEmailList() {
		
		ArrayList<String> emailList = new ArrayList<String>();
		
		emailList.add("one");
		emailList.add("two");
		
		return emailList;
	}

	public ArrayList<Person> getPersonList() {

		ArrayList<Person> persons = new ArrayList<Person>();
		
		persons.add(new Person("one", "one", "one", "one", "one", "one", "one"));
		persons.add(new Person("two", "two", "two", "two", "two", "two", "two"));
		persons.add(new Person("three", "three", "three", "three", "three", "three", "three"));
		persons.add(new Person("four", "four", "four", "four", "four", "four", "four"));
				
		return persons;
	}

	public Person addPerson() {

		Person person = new Person("two", "two", "two", "two", "two", "two", "two");
		
		return person;
	}

	public Person updatePerson() {

		Person person = new Person("three", "three", "three", "three", "three", "three", "three");
		
		return person;
	}

	public Person removePerson() {

		Person person = new Person("four", "four", "four", "four", "four", "four", "four");
		
		return person;
	}

}
