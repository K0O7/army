package solvd.army.factory;

public interface IArmyFactory {
    IUnit createUnit();
    IMission createMission();
}
