package solvd.army;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Division")
@XmlAccessorType(XmlAccessType.FIELD)
public class Division {
	@XmlAttribute
    private int id;
	@XmlElement
    private String division_name;
	@XmlElement
    private Soldier soldier;
	@XmlElement
    private Unit unit;
	
    public Division() {}

    public Division(int id, String divisionName, Soldier soldier, Unit unit) {
        this.id = id;
        this.division_name = divisionName;
        this.soldier = soldier;
        this.unit = unit;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDivision_name() {
		return division_name;
	}

	public void setDivision_name(String division_name) {
		this.division_name = division_name;
	}

	public Soldier getSoldier() {
		return soldier;
	}

	public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
    
}

