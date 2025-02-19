package solvd.army.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MeleeAttack implements IAttackStrategy {
	private static final Logger logger = LogManager.getLogger(MeleeAttack.class);
	@Override
	public void attack() {
		logger.info("Attacking with close-range melee combat!");
	}

}
