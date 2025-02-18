package solvd.army;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Department")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department {
	@XmlAttribute
    private int id;
	@XmlElement
    private String departmentName;
	@XmlElement
    private Division division;
	
    public Department() {}

    public Department(int id, String departmentName, Division division) {
        this.id = id;
        this.departmentName = departmentName;
        this.division = division;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}
    
}
