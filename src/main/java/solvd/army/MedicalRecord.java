package solvd.army;
import java.util.List;

public class MedicalRecord {
    private int id;
    private String bloodType;
    private String rhFactor;
    private Soldier soldier;
    private List<Allergy> allergies;

    public MedicalRecord(int id, String bloodType, String rhFactor, Soldier soldier) {
        this.id = id;
        this.bloodType = bloodType;
        this.rhFactor = rhFactor;
        this.soldier = soldier;
    }

    // Getters and Setters
}

