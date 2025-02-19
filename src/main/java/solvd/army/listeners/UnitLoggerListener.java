package solvd.army.listeners;

import solvd.army.Unit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnitLoggerListener implements UnitListener {
	private static final Logger logger = LogManager.getLogger(UnitLoggerListener.class);
    @Override
    public void onUnitCreated(Unit unit) {
    	logger.info("Unit Created: " + unit.getUnitName());
    }

    @Override
    public void onUnitUpdated(Unit unit) {
    	logger.info("Unit Updated: " + unit.getUnitName());
    }

    @Override
    public void onUnitDeleted(long unitId) {
    	logger.info("Unit Deleted with ID: " + unitId);
    }
}
