package solvd.army.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StealthAttack implements IAttackStrategy {
	private static final Logger logger = LogManager.getLogger(StealthAttack.class);
	@Override
	public void attack() {
		logger.info("Attacking from the shadows undetected!");
	}

}
