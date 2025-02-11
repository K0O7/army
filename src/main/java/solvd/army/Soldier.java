package solvd.army;
import java.util.List;

public class Soldier {
	private long id;
    private String first_name;
    private String last_name;
    private Rank rank;
    private MedicalRecord medicalRecord;
    private List<SoldierTraining> trainings;
    private List<SoldierEquipment> equipmentList;
    private Division division;

    public Soldier(long id, String firstName, String lastName) {
        this.id = id;
        this.first_name = firstName;
        this.last_name = lastName;
    }
    

	public Soldier() {
	}

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String lastName) {
		this.last_name = lastName;
	}
}

