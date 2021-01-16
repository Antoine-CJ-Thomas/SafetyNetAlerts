package com.safetynet.alerts.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.PersonRepository;

@SpringBootTest
class PersonRepositoryTest {

	private PersonRepository personRepository;

	@Mock
	private Person person, updatedPerson;

    @BeforeEach
    private void beforeEach() {
    	
    	personRepository = new PersonRepository();
    }

	@Test
	void test_getPersonList() {

    	//GIVEN
		ArrayList<Person> personList = new ArrayList<Person>();
        
    	//WHEN
		personRepository.setPersonList(personList);
    	
    	//THEN
        assertEquals(personList, personRepository.getPersonList());
	}


	@Test
	void test_addPerson() {

    	//GIVEN
        
    	//WHEN
    	
    	//THEN
        assertEquals(person, personRepository.addPerson(person));
	}

	@Test
	void test_updatePerson() {

    	//GIVEN
        
    	//WHEN
		personRepository.addPerson(person);
    	
    	//THEN
        assertEquals(updatedPerson, personRepository.updatePerson(0, updatedPerson));
	}

	@Test
	void test_removePerson() {

    	//GIVEN
        
    	//WHEN
		personRepository.addPerson(person);
    	
    	//THEN
        assertEquals(person, personRepository.removePerson(0, person));
	}
}
