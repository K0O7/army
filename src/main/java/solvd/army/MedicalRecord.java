package solvd.army;
import java.util.List;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "MedicalRecord")
@XmlAccessorType(XmlAccessType.FIELD)
public class MedicalRecord {
	@XmlAttribute
    private long id;
	@XmlElement
    private String blood_type;
	@XmlElement
    private String rh;
	@XmlElement
    private Soldier soldier;
	@XmlElementWrapper(name = "allergies")
	@XmlElement(name = "allergy")
    private List<Allergy> allergies;
	@XmlTransient
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

