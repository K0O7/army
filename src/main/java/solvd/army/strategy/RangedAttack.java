package solvd.army.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RangedAttack implements IAttackStrategy {
	private static final Logger logger = LogManager.getLogger(RangedAttack.class);
	@Override
	public void attack() {
		logger.info("Attacking with long-range weapons!");
	}

}
