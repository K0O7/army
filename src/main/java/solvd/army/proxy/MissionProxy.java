package solvd.army.proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MissionProxy implements IMission {
	private static final Logger logger = LogManager.getLogger(MissionProxy.class);
    private SecretMission secretMission;
    private String missionName;
    private boolean hasClearance;

    public MissionProxy(String missionName, boolean hasClearance) {
        this.missionName = missionName;
        this.hasClearance = hasClearance;
    }

    @Override
    public void executeMission() {
        if (!hasClearance) {
        	logger.info("ACCESS DENIED: You do not have clearance for this mission.");
            return;
        }

        if (secretMission == null) {
            secretMission = new SecretMission(missionName);
        }

        secretMission.executeMission();
    }
}
