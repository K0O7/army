package solvd.army.factory;

public class AirforceFactory implements IArmyFactory {
    @Override
    public IUnit createUnit() {
        return new AirforceUnit();
    }

    @Override
    public IMission createMission() {
        return new AirforceMission();
    }
}
