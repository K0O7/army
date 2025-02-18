package solvd.army;
import java.util.List;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Soldier")
@XmlAccessorType(XmlAccessType.FIELD)
public class Soldier {
	@XmlAttribute
	private long id;
	@XmlElement
    private String first_name;
	@XmlElement
    private String last_name;
	@XmlElement 
    private Rank rank;
	@XmlTransient 
    private MedicalRecord medicalRecord;
    @XmlElementWrapper(name = "trainings")
    @XmlElement(name = "training")
    private List<SoldierTraining> trainings;
    @XmlTransient 
    private List<SoldierEquipment> equipmentList;
    @XmlTransient 
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


	public Rank getRank() {
		return rank;
	}


	public void setRank(Rank rank) {
		this.rank = rank;
	}


	public List<SoldierTraining> getTrainings() {
		return trainings;
	}


	public void setTrainings(List<SoldierTraining> trainings) {
		this.trainings = trainings;
	}	
}

