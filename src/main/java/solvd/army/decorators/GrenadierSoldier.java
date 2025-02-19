package solvd.army.decorators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GrenadierSoldier extends SoldierDecorator {
	private static final Logger logger = LogManager.getLogger(GrenadierSoldier.class);
    public GrenadierSoldier(ISoldier decoratedSoldier) {
        super(decoratedSoldier);
    }

    @Override
    public void attack() {
        super.attack();
        logger.info("Grenadier Soldier throws a grenade.");
    }
}
