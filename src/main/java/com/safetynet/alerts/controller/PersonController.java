package com.safetynet.alerts.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.PersonService;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public ArrayList<Person> getPersonList() {
        return personService.getPersonList();
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person product) {   	
        return personService.addPerson();
    }

    @PatchMapping("/person")
    public Person updatePerson(@RequestBody Person product) {   	
        return personService.updatePerson();
    }

    @DeleteMapping("/person")
    public Person removePerson(@RequestBody String firstname, String lastName) {   
        return personService.removePerson();
    }
}
