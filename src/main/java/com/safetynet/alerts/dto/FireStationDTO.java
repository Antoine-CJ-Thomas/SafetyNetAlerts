package com.safetynet.alerts.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.safetynet.alerts.model.FireStation;

@Component
public class FireStationDTO {

	private ArrayList<FireStation> fireStations = new ArrayList<FireStation>();

	public ArrayList<FireStation> getFireStationList() {
		return fireStations;
	}

	public void addFireStation(FireStation fireStation) {
		fireStations.add(fireStation);
	}

	public void updateFireStation(FireStation fireStation) {

	}

	public void removeFireStation(FireStation fireStation) {
		fireStations.remove(fireStation);
	}
}
