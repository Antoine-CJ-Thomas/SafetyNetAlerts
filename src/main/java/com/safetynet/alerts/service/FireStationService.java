package com.safetynet.alerts.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.safetynet.alerts.dto.FireStationDTO;
import com.safetynet.alerts.model.FireStation;

@Service
public class FireStationService {

	public ArrayList<FireStation> getFireStationList(FireStationDTO fireStationDTO) {
		return fireStationDTO.getFireStationList();
	}

	public FireStation addFireStation(FireStationDTO fireStationDTO, FireStation fireStation) {
		fireStationDTO.addFireStation(fireStation);
		return fireStation;
	}

	public FireStation updateFireStation(FireStationDTO fireStationDTO, FireStation fireStation) {
		fireStationDTO.updateFireStation(fireStation);
		return fireStation;
	}

	public FireStation removeFireStation(FireStationDTO fireStationDTO, FireStation fireStation) {

		ArrayList<FireStation> fireStationList = fireStationDTO.getFireStationList();
		FireStation deletedFireStation = null;

		for (FireStation f : fireStationList) {

			if (f.equals(fireStation)) {

				fireStationDTO.removeFireStation(f);
				deletedFireStation = f;
				break;
			}
		}
		return deletedFireStation;
	}
}