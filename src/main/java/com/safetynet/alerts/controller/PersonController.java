package com.safetynet.alerts.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsoniter.output.JsonStream;
import com.safetynet.alerts.dto.ChildInfoDTO;
import com.safetynet.alerts.dto.CommunityEmailInfoDTO;
import com.safetynet.alerts.dto.FireInfoDTO;
import com.safetynet.alerts.dto.FloodInfoDTO;
import com.safetynet.alerts.dto.PhoneInfoDTO;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.MedicalRecordService;
import com.safetynet.alerts.service.PersonService;

/**
 * This class allows to interact with the application via person http requests
 */
@RestController
public class PersonController {

    private static final Logger logger = LogManager.getLogger("PersonController");
    
	private static PersonService personService;
	private static MedicalRecordService medicalRecordService;
	
	public PersonController() {}

	public PersonController(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordRepository medicalRecordRepository) {
        logger.info("PersonController(" + personRepository + ", " + fireStationRepository + ", " + medicalRecordRepository + ")");
        
		personService = new PersonService(personRepository, fireStationRepository, medicalRecordRepository);
		medicalRecordService = new MedicalRecordService(personRepository, fireStationRepository, medicalRecordRepository);
	}

	@GetMapping("/person")
	public String getPersonList() {
        logger.info("getPersonList()");
		return JsonStream.serialize(personService.getPersonList());
	}

	@PostMapping("/person")
	public String addPerson(@RequestBody Person person) {
        logger.info("addPerson()");
		return JsonStream.serialize(personService.addPerson(person));
	}

	@PutMapping("/person")
	public String updatePerson(@RequestBody Person person) {
        logger.info("updatePerson()");
		return JsonStream.serialize(personService.updatePerson(person));
	}

	@DeleteMapping("/person")
	public String removePerson(@RequestBody Person person) {
        logger.info("removePerson()");
		return JsonStream.serialize(personService.removePerson(person));
	}

	@GetMapping("/childAlert/{address}")
	public String childAlert(@PathVariable("address") final String address) {
        logger.info("childAlert(" + address + ")");
		return JsonStream.serialize(personService.getChildAlertInfo(medicalRecordService, new ChildInfoDTO(address)));
	}

	@GetMapping("/phoneAlert/{station}")
	public String phoneAlert(@PathVariable("station") final String station) {
        logger.info("phoneAlert(" + station + ")");
		return JsonStream.serialize(personService.getPhoneInfo(new PhoneInfoDTO(station)));
	}

	@GetMapping("/fire/{address}")
	public String fireInfo(@PathVariable("address") final String address) {
        logger.info("fireInfo(" + address + ")");
		return JsonStream.serialize(personService.getFireInfo(medicalRecordService, new FireInfoDTO(address)));
	}

	@GetMapping("/flood/{stationList}")
	public String floodInfo(@PathVariable("stationList") final ArrayList<String> stationList) {
        logger.info("Get /flood/" + stationList);
		return JsonStream.serialize(personService.getFloodInfo(medicalRecordService, new FloodInfoDTO(stationList)));
	}

	@GetMapping("/communityEmail/{city}")
	public String communityEmail(@PathVariable("city") final String city) {
        logger.info("communityEmail(" + city + ")");
		return JsonStream.serialize(personService.getCommunityEmailInfo(new CommunityEmailInfoDTO(city)));
	}
}