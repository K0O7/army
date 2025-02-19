package solvd.army.decorators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicSoldier implements ISoldier {
	private static final Logger logger = LogManager.getLogger(BasicSoldier.class);
    @Override
    public void attack() {
    	logger.info("Soldier attacks with a basic rifle.");
    }
}
