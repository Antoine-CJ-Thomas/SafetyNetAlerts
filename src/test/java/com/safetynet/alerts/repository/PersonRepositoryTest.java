package com.safetynet.alerts.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	private Person person;
	@Mock
	private Person updatedPerson;

    @BeforeEach
    private void setUpPerTest() {
    	
    	personRepository = new PersonRepository();
    }

	@Test
	void test_addFireStation() {

    	//GIVEN
        
    	//WHEN
		personRepository.addPerson(person);
    	
    	//THEN
        assertEquals(true, personRepository.getPersonList().contains(person));
	}

	@Test
	void test_updateFireStation() {

    	//GIVEN
        
    	//WHEN
		personRepository.addPerson(person);
		personRepository.updatePerson(personRepository.getPersonList().indexOf(person), updatedPerson);
    	
    	//THEN
        assertEquals(true, personRepository.getPersonList().contains(updatedPerson));
	}

	@Test
	void test_removeFireStation() {

    	//GIVEN
        
    	//WHEN
		personRepository.addPerson(person);
		personRepository.removePerson(person);
    	
    	//THEN
        assertEquals(false, personRepository.getPersonList().contains(person));
	}
}
