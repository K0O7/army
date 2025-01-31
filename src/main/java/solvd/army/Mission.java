package solvd.army;

import java.util.Date;

public class Mission {
    private int id;
    private String missionName;
    private Date missionDate;
    private String location;

    public Mission(int id, String missionName, Date missionDate, String location) {
        this.id = id;
        this.missionName = missionName;
        this.missionDate = missionDate;
        this.location = location;
    }

    // Getters and Setters
}
