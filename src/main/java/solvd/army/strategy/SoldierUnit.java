package solvd.army.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SoldierUnit {
	private static final Logger logger = LogManager.getLogger(SoldierUnit.class);
    private String name;
    private IAttackStrategy attackStrategy;

    public SoldierUnit(String name, IAttackStrategy attackStrategy) {
        this.name = name;
        this.attackStrategy = attackStrategy;
    }

    public void setAttackStrategy(IAttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void executeAttack() {
    	logger.info(name + ": ");
        attackStrategy.attack();
    }
}
