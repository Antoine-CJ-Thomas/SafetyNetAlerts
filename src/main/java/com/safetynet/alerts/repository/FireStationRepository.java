package com.safetynet.alerts.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.safetynet.alerts.model.FireStation;

@Component
public class FireStationRepository {

    private static final Logger logger = LogManager.getLogger("FireStationRepository");

	private ArrayList<FireStation> fireStations = new ArrayList<FireStation>();

	public ArrayList<FireStation> getFireStationList() {
        logger.info("getFireStationList()");
		return fireStations;
	}

	public FireStation addFireStation(FireStation fireStation) {
        logger.info("addFireStation(" + fireStation + ")");
		fireStations.add(fireStation);
		return fireStation;
	}

	public FireStation updateFireStation(int index, FireStation fireStation) {
        logger.info("updateFireStation(" + fireStation + ")");
		fireStations.set(index, fireStation);
		return fireStation;
	}

	public FireStation removeFireStation(FireStation fireStation) {
        logger.info("removeFireStation(" + fireStation + ")");
		fireStations.remove(fireStation);
		return fireStation;
	}
}
