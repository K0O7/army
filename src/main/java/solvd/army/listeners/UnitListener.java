package solvd.army.listeners;

import solvd.army.Unit;

public interface UnitListener {
    void onUnitCreated(Unit unit);
    void onUnitUpdated(Unit unit);
    void onUnitDeleted(long id);
}
