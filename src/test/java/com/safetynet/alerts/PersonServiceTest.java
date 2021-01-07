package com.safetynet.alerts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.PersonService;

@SpringBootTest
class PersonServiceTest {

	private PersonService personService;

	private ArrayList<Person> persons;
	@Mock
	private Person personFromList;
	@Mock
	private Person person;
	@Mock
	private PersonRepository personRepository;

    @BeforeEach
    private void setUpPerTest() {
    	
    	personService = new PersonService();
    }

	@Test
	void test_getPersonList() {

    	//GIVEN
		persons = new ArrayList<Person>();
        
    	//WHEN
		when(personRepository.getPersonList()).thenReturn(persons);
    	
    	//THEN
        assertEquals(persons, personService.getPersonList(personRepository));
	}
    
	@Test
	void test_addPerson() {

    	//GIVEN
        
    	//WHEN
		when(personRepository.addPerson(any(Person.class))).thenReturn(person);
    	
    	//THEN
        assertEquals(person, personService.addPerson(personRepository, person));
	}
    
	@Test
	void test_updatePerson_withEmptyRepository() {

    	//GIVEN
        
    	//WHEN
		when(personRepository.updatePerson(any(Integer.class), any(Person.class))).thenReturn(person);
		
    	//THEN
        assertEquals(person, personService.updatePerson(personRepository, person));
	}
    
	@Test
	void test_updatePerson_withRepositoryThatContainNoCommonData() {

    	//GIVEN
		persons = new ArrayList<Person>();
        
    	//WHEN
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(personFromList.getFirstName()).thenReturn("another firstname");
		when(personFromList.getLastName()).thenReturn("another lastname");
		when(personRepository.getPersonList()).thenReturn(persons);
		when(personRepository.updatePerson(any(Integer.class), any(Person.class))).thenReturn(person);
		persons.add(personFromList);
		
    	//THEN
        assertEquals(person, personService.updatePerson(personRepository, person));
	}
    
	@Test
	void test_updatePerson_withRepositoryThatContainPartiallyCommonData() {

    	//GIVEN
		persons = new ArrayList<Person>();
        
    	//WHEN
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(personFromList.getFirstName()).thenReturn("firstname");
		when(personFromList.getLastName()).thenReturn("another lastname");
		when(personRepository.getPersonList()).thenReturn(persons);
		when(personRepository.updatePerson(any(Integer.class), any(Person.class))).thenReturn(person);
		persons.add(personFromList);
		
    	//THEN
        assertEquals(person, personService.updatePerson(personRepository, person));
	}
    
	@Test
	void test_updatePerson_withRepositoryThatContainCommonData() {

    	//GIVEN
		persons = new ArrayList<Person>();
        
    	//WHEN
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(personFromList.getFirstName()).thenReturn("firstname");
		when(personFromList.getLastName()).thenReturn("lastname");
		when(personRepository.getPersonList()).thenReturn(persons);
		when(personRepository.updatePerson(any(Integer.class), any(Person.class))).thenReturn(person);
		persons.add(personFromList);
		
    	//THEN
        assertEquals(person, personService.updatePerson(personRepository, person));
	}
    
	@Test
	void test_removePerson_withEmptyRepository() {

    	//GIVEN
        
    	//WHEN
		when(personRepository.removePerson(null)).thenReturn(person);
		
    	//THEN
        assertEquals(person, personService.removePerson(personRepository, person));
	}
    
	@Test
	void test_removePerson_withRepositoryThatContainNoCommonData() {

    	//GIVEN
		persons = new ArrayList<Person>();
        
    	//WHEN
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(personFromList.getFirstName()).thenReturn("another firstname");
		when(personFromList.getLastName()).thenReturn("another lastname");
		when(personRepository.getPersonList()).thenReturn(persons);
		when(personRepository.removePerson(null)).thenReturn(person);
		persons.add(personFromList);
		
    	//THEN
        assertEquals(person, personService.removePerson(personRepository, person));
	}
    
	@Test
	void test_removePerson_withRepositoryThatContainPartiallyCommonData() {

    	//GIVEN
		persons = new ArrayList<Person>();
        
    	//WHEN
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(personFromList.getFirstName()).thenReturn("firstname");
		when(personFromList.getLastName()).thenReturn("another lastname");
		when(personRepository.getPersonList()).thenReturn(persons);
		when(personRepository.removePerson(null)).thenReturn(person);
		persons.add(personFromList);
		
    	//THEN
        assertEquals(person, personService.removePerson(personRepository, person));
	}
    
	@Test
	void test_removePerson_withRepositoryThatContainCommonData() {

    	//GIVEN
		persons = new ArrayList<Person>();
        
    	//WHEN
		when(person.getFirstName()).thenReturn("firstname");
		when(person.getLastName()).thenReturn("lastname");
		when(personFromList.getFirstName()).thenReturn("firstname");
		when(personFromList.getLastName()).thenReturn("lastname");
		when(personRepository.getPersonList()).thenReturn(persons);
		when(personRepository.removePerson(any(Person.class))).thenReturn(person);
		persons.add(personFromList);
		
    	//THEN
        assertEquals(person, personService.removePerson(personRepository, person));
	}
}