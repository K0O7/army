package solvd.army;
import java.time.LocalDate;
import java.util.Date;

public class SoldierTraining {
    private long id;
    private Soldier soldier;
    private long soldiers_id;
    private TrainingProgram trainingProgram;
    private long training_programs_id;
    private LocalDate startDate;
    private LocalDate endDate;

    public SoldierTraining(long id, Soldier soldier, TrainingProgram trainingProgram, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.soldier = soldier;
        this.trainingProgram = trainingProgram;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public SoldierTraining() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Soldier getSoldier() {
		return soldier;
	}

	public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
	}

	public long getSoldierId() {
		return soldiers_id;
	}

	public void setSoldierId(long soldiers_id) {
		this.soldiers_id = soldiers_id;
	}

	public TrainingProgram getTrainingProgram() {
		return trainingProgram;
	}

	public void setTrainingProgram(TrainingProgram trainingProgram) {
		this.trainingProgram = trainingProgram;
	}

	public long getTrainingProgramsId() {
		return training_programs_id;
	}

	public void setTrainingProgramsId(long training_programs_id) {
		this.training_programs_id = training_programs_id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate localDate) {
		this.startDate = localDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
    
}

