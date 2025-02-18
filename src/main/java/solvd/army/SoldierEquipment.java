package solvd.army;



import java.time.LocalDate;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import solvd.LocalDateAdapter;

@XmlRootElement(name = "SoldierEquipment")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldierEquipment {
	@XmlAttribute
    private int id;
	@XmlElement
    private Soldier soldier;
	@XmlElement
    private Equipment equipment;
	@XmlElement
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate issue_date;
	@XmlElement
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate return_date;
	
    public SoldierEquipment() {}

    public SoldierEquipment(int id, Soldier soldier, Equipment equipment, LocalDate issueDate, LocalDate returnDate) {
        this.id = id;
        this.soldier = soldier;
        this.equipment = equipment;
        this.issue_date = issueDate;
        this.return_date = returnDate;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Soldier getSoldier() {
		return soldier;
	}

	public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public LocalDate getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(LocalDate issue_date) {
		this.issue_date = issue_date;
	}

	public LocalDate getReturn_date() {
		return return_date;
	}

	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}
    
}
