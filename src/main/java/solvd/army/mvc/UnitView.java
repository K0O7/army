package solvd.army.mvc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnitView {
	private static final Logger logger = LogManager.getLogger(UnitView.class);
    public void displayUnitDetails(int id, String unitName) {
    	logger.info("=== Unit Details ===");
    	logger.info("ID: " + id);
    	logger.info("Name: " + unitName);
    	logger.info("====================");
    }
}
