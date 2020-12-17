package com.safetynet.alerts.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.dto.FireStationDTO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.service.FireStationService;

@RestController
public class FireStationController {

	@Autowired
	private FireStationService fireStationService;

	private static FireStationDTO fireStationDAO;

	public FireStationController(FireStationDTO fireStationDAO) {
		FireStationController.fireStationDAO = fireStationDAO;
	}

	@GetMapping("/firestation")
	public ArrayList<FireStation> getFireStationList() {
		return fireStationService.getFireStationList(fireStationDAO);
	}

	@PostMapping("/firestation")
	public FireStation addFireStation(@RequestBody FireStation fireStation) {
		return fireStationService.addFireStation(fireStationDAO, fireStation);
	}

	@PatchMapping("/fireStation")
	public FireStation updateFireStation(@RequestBody FireStation fireStation) {
		return fireStationService.updateFireStation(fireStationDAO, fireStation);
	}

	@DeleteMapping("/firestation")
	public FireStation removeFireStation(@RequestBody FireStation fireStation) {
		return fireStationService.removeFireStation(fireStationDAO, fireStation);
	}
}