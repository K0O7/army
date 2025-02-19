package solvd.army.decorators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SniperSoldier extends SoldierDecorator {
	private static final Logger logger = LogManager.getLogger(SniperSoldier.class);
    public SniperSoldier(ISoldier decoratedSoldier) {
        super(decoratedSoldier);
    }

    @Override
    public void attack() {
        super.attack();
        logger.info("Sniper Soldier takes an accurate long-range shot.");
    }
}
