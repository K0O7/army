package solvd.army.decorators;

public abstract class SoldierDecorator implements ISoldier {
    protected ISoldier decoratedSoldier;

    public SoldierDecorator(ISoldier decoratedSoldier) {
        this.decoratedSoldier = decoratedSoldier;
    }
	@Override
	public void attack() {
		decoratedSoldier.attack();
	}

}
