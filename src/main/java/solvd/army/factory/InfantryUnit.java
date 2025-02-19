package solvd.army.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InfantryUnit implements IUnit {
	private static final Logger logger = LogManager.getLogger(InfantryUnit.class);
    @Override
    public void displayInfo() {
    	logger.info("This is an Infantry Unit.");
    }
}
