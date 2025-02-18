package solvd.army;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Equipment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Equipment {
	@XmlAttribute
    private int id;
	@XmlElement
    private String equipment_name;
	@XmlElement
    private String equipment_type;
	
    public Equipment() {}

    public Equipment(int id, String equipmentName, String equipmentType) {
        this.id = id;
        this.equipment_name = equipmentName;
        this.equipment_type = equipmentType;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEquipment_name() {
		return equipment_name;
	}

	public void setEquipment_name(String equipment_name) {
		this.equipment_name = equipment_name;
	}

	public String getEquipment_type() {
		return equipment_type;
	}

	public void setEquipment_type(String equipment_type) {
		this.equipment_type = equipment_type;
	}
    
}
