package solvd.army;

import java.time.LocalDate;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import solvd.LocalDateAdapter;

@XmlRootElement(name = "Mission")
@XmlAccessorType(XmlAccessType.FIELD)
public class Mission {
	@XmlAttribute
    private int id;
	@XmlElement
    private String mission_name;
	@XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate mission_date;
	@XmlElement
    private String location;
    
    public Mission() {}

    public Mission(int id, String missionName, LocalDate missionDate, String location) {
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
