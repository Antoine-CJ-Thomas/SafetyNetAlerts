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
		return fireStationDTO.addFireStation(fireStation);
	}

	public FireStation updateFireStation(FireStationDTO fireStationDTO, FireStation fireStation) {

		FireStation updatedFireStation = null;
		
		for (FireStation f : fireStationDTO.getFireStationList()) {

			if (f.getAddress().equals(fireStation.getAddress())) {
				updatedFireStation = f;
				break;
			}
		}		
		return fireStationDTO.updateFireStation(fireStationDTO.getFireStationList().indexOf(updatedFireStation), fireStation);
	}

	public FireStation removeFireStation(FireStationDTO fireStationDTO, FireStation fireStation) {

		FireStation deletedFireStation = null;

		for (FireStation f : fireStationDTO.getFireStationList()) {

			if (f.getAddress().equals(fireStation.getAddress())) {
				deletedFireStation = f;
				break;
			}
		}
		return fireStationDTO.removeFireStation(deletedFireStation);
	}
}