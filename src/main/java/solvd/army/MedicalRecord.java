package solvd.army;
import java.util.List;

public class MedicalRecord {
    private long id;
    private String blood_type;
    private String rh;
    private Soldier soldier;
    private List<Allergy> allergies;
    private long soldier_id;

    public MedicalRecord(int id, String bloodType, String rhFactor, Soldier soldier) {
        this.id = id;
        this.blood_type = bloodType;
        this.rh = rhFactor;
        this.soldier = soldier;
    }
    
    public MedicalRecord() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBloodType() {
		return blood_type;
	}

	public void setBloodType(String bloodType) {
		this.blood_type = bloodType;
	}

	public String getRh() {
		return rh;
	}

	public void setRh(String rhFactor) {
		this.rh = rhFactor;
	}

	public Soldier getSoldier() {
		return soldier;
	}

	public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
	}
	
	public long getSoldierId() {
		return soldier_id;
	}

	public void setSoldierId(long soldier_id) {
		this.soldier_id = soldier_id;
	}

	public List<Allergy> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<Allergy> allergies) {
		this.allergies = allergies;
	}

    
}

