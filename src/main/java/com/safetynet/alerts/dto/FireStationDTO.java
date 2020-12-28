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

	public FireStation addFireStation(FireStation fireStation) {
		fireStations.add(fireStation);
		return fireStation;
	}

	public FireStation updateFireStation(int index, FireStation fireStation) {
		fireStations.set(index, fireStation);
		return fireStation;
	}

	public FireStation removeFireStation(FireStation fireStation) {
		fireStations.remove(fireStation);
		return fireStation;
	}
}
