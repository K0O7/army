package solvd.army;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "UnitMission")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnitMission {
	@XmlAttribute
    private int id;
	@XmlElement
    private Mission mission;
	@XmlElement
    private Unit unit;
	
	public UnitMission() {}

    public UnitMission(int id, Mission mission, Unit unit) {
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

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
    
}
