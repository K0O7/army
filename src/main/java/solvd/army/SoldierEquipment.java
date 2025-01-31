package solvd.army;

import java.util.Date;

public class SoldierEquipment {
    private int id;
    private Soldier soldier;
    private Equipment equipment;
    private Date issueDate;
    private Date returnDate;

    public SoldierEquipment(int id, Soldier soldier, Equipment equipment, Date issueDate, Date returnDate) {
        this.id = id;
        this.soldier = soldier;
        this.equipment = equipment;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    // Getters and Setters
}
