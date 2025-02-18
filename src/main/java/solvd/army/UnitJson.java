package solvd.army;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UnitJson {
	@JsonProperty("id")
    private int id;
	@JsonProperty("unit_name")
    private String unit_name;
	@JsonProperty("unit_missions")
    private List<UnitMissionJson> unitMissions;
    
    public UnitJson() {}

    public UnitJson(int id, String unitName) {
        this.id = id;
        this.unit_name = unitName;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnitName() {
		return unit_name;
	}

	public void setUnitName(String unitName) {
		this.unit_name = unitName;
	}

	public List<UnitMissionJson> getUnitMissions() {
		return unitMissions;
	}

	public void setUnitMissions(List<UnitMissionJson> unitMissions) {
		this.unitMissions = unitMissions;
	}
    
}
