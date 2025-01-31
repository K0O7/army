package solvd.army;
import java.util.Date;

public class SoldierTraining {
    private int id;
    private Soldier soldier;
    private TrainingProgram trainingProgram;
    private Date startDate;
    private Date endDate;

    public SoldierTraining(int id, Soldier soldier, TrainingProgram trainingProgram, Date startDate, Date endDate) {
        this.id = id;
        this.soldier = soldier;
        this.trainingProgram = trainingProgram;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
}

