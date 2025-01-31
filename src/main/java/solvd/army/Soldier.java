package solvd.army;
import java.util.List;

public class Soldier {
	private long id;
    private String firstName;
    private String lastName;
    private Rank rank;
    private MedicalRecord medicalRecord;
    private List<SoldierTraining> trainings;
    private List<SoldierEquipment> equipmentList;
    private Division division;

    public Soldier(long id, String firstName, String lastName, Rank rank) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rank = rank;
    }

	public Soldier() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

