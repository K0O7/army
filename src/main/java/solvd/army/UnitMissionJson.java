package solvd.army;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UnitMissionJson {
	@JsonProperty("id")
    private int id;
	@JsonProperty("mission")
    private MissionJson mission;
	@JsonIgnore
    private UnitJson unit;
	
	public UnitMissionJson() {}

    public UnitMissionJson(int id, MissionJson mission, UnitJson unit) {
        this.id = id;
        this.mission = mission;
        this.unit = unit;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MissionJson getMission() {
		return mission;
	}

	public void setMission(MissionJson mission) {
		this.mission = mission;
	}

	public UnitJson getUnit() {
		return unit;
	}

	public void setUnit(UnitJson unit) {
		this.unit = unit;
	}
    
}
