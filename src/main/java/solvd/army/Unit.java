package solvd.army;

import java.util.List;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Unit")
@XmlAccessorType(XmlAccessType.FIELD)
public class Unit {
	@XmlAttribute
    private long id;
	@XmlElement
    private String unit_name;
	@XmlElementWrapper(name = "unitMissions")
    @XmlElement(name = "UnitMission")
    private List<UnitMission> unitMissions;
    
    public Unit() {}

    public Unit(long id, String unitName) {
        this.id = id;
        this.unit_name = unitName;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUnitName() {
		return unit_name;
	}

	public void setUnitName(String unitName) {
		this.unit_name = unitName;
	}

	public List<UnitMission> getUnitMissions() {
		return unitMissions;
	}

	public void setUnitMissions(List<UnitMission> unitMissions) {
		this.unitMissions = unitMissions;
	}
    
}
