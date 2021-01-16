package com.safetynet.alerts.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.safetynet.alerts.model.FireStation;

/**
 * This class allows to interact with a fire station repository
 */
@Component
public class FireStationRepository {

    private static final Logger logger = LogManager.getLogger("FireStationRepository");

	private ArrayList<FireStation> fireStationList = new ArrayList<FireStation>();

	public void setFireStationList(ArrayList<FireStation> fireStationList) {
        logger.info("setFireStationList(" + fireStationList + ")");
		this.fireStationList = fireStationList;
	}

	public ArrayList<FireStation> getFireStationList() {
        logger.info("getFireStationList()");
		return fireStationList;
	}

	public FireStation addFireStation(FireStation fireStation) {
        logger.info("addFireStation(" + fireStation + ")");
        fireStationList.add(fireStation);
		return fireStation;
	}

	public FireStation updateFireStation(int index, FireStation fireStation) {
        logger.info("updateFireStation(" + index + ", " + fireStation + ")");
        fireStationList.set(index, fireStation);
		return fireStation;
	}

	public FireStation removeFireStation(int index, FireStation fireStation) {
        logger.info("removeFireStation(" + index + ", " + fireStation + ")");
        fireStationList.remove(index);
		return fireStation;
	}
}
