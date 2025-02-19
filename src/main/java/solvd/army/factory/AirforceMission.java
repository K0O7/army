package solvd.army.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AirforceMission implements IMission {
	private static final Logger logger = LogManager.getLogger(AirforceMission.class);
    @Override
    public void execute() {
    	logger.info("Airforce Mission: Aerial strike in progress.");
    }
}