package solvd.army.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InfantryMission implements IMission {
	private static final Logger logger = LogManager.getLogger(InfantryMission.class);
    @Override
    public void execute() {
    	logger.info("Infantry Mission: Ground attack initiated.");
    }
}
