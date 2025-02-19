package solvd.army.factory;

public class InfantryFactory implements IArmyFactory {
    @Override
    public IUnit createUnit() {
        return new InfantryUnit();
    }

    @Override
    public IMission createMission() {
        return new InfantryMission();
    }
}