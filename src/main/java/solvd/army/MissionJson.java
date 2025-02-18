package solvd.army;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MissionJson {
	@JsonProperty("id")
    private int id;
    @JsonProperty("mission_name")
    private String mission_name;
    @JsonProperty("mission_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate mission_date;
    @JsonProperty("location")
    private String location;
    
    public MissionJson() {}

    public MissionJson(int id, String missionName, LocalDate missionDate, String location) {
        this.id = id;
        this.mission_name = missionName;
        this.mission_date = missionDate;
        this.location = location;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMissionName() {
		return mission_name;
	}

	public void setMissionName(String missionName) {
		this.mission_name = missionName;
	}

	public LocalDate getMissionDate() {
		return mission_date;
	}

	public void setMissionDate(LocalDate missionDate) {
		this.mission_date = missionDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
    
}
