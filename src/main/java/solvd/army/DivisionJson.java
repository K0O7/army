package solvd.army;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DivisionJson {
	@JsonProperty("id")
    private int id;
	@JsonProperty("division_name")
    private String division_name;
	@JsonIgnore
    private Soldier soldier;
	@JsonProperty("unit")
    private UnitJson unit;
	
    public DivisionJson() {}

    public DivisionJson(int id, String divisionName, Soldier soldier, UnitJson unit) {
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

	public UnitJson getUnit() {
		return unit;
	}

	public void setUnit(UnitJson unit) {
		this.unit = unit;
	}
    
}

