package solvd.army;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Allergy")
@XmlAccessorType(XmlAccessType.FIELD)
public class Allergy {
	@XmlAttribute
    private long id;
	@XmlElement
    private String allergen;
	@XmlElement
    private MedicalRecord medicalRecord;
	@XmlTransient
    private long medical_record_id;

    public Allergy(long id, String allergen, MedicalRecord medicalRecord) {
        this.id = id;
        this.allergen = allergen;
        this.medicalRecord = medicalRecord;
    }
    
    public Allergy() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAllergen() {
		return allergen;
	}

	public void setAllergen(String allergen) {
		this.allergen = allergen;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public long getMedicalRecordId() {
		return medical_record_id;
	}

	public void setMedicalRecordId(long medical_record_id) {
		this.medical_record_id = medical_record_id;
	}
}

