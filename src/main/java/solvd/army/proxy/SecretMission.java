package solvd.army.proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SecretMission implements IMission {
	private static final Logger logger = LogManager.getLogger(SecretMission.class);
    private String missionName;

    public SecretMission(String missionName) {
        this.missionName = missionName;
    }
    
	@Override
	public void executeMission() {
		logger.info("Executing secret mission: " + missionName);
	}
}
