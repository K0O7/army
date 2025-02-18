package solvd.army;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentJson {
	@JsonProperty("id")
    private int id;
	@JsonProperty("department_name")
    private String departmentName;
	@JsonProperty("division")
    private DivisionJson division;
	
    public DepartmentJson() {}

    public DepartmentJson(int id, String departmentName, DivisionJson division) {
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

	public DivisionJson getDivision() {
		return division;
	}

	public void setDivision(DivisionJson division) {
		this.division = division;
	}
    
}
