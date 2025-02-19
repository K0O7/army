package solvd.army.facade;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.util.List;

import daos.myBatis.IMissionDao;
import daos.myBatis.IUnitDao;
import daos.myBatis.IUnitMissionDao;
import solvd.army.Mission;
import solvd.army.Unit;
import solvd.army.UnitMission;

public class UnitServiceFacade {
	private static final Logger logger = LogManager.getLogger(UnitServiceFacade.class);
	private final IUnitDao unitDao;
    private final IUnitMissionDao unitMissionDao;
    private final IMissionDao missionDao;

    public UnitServiceFacade(IUnitDao unitDao, IUnitMissionDao unitMissionDao, IMissionDao missionDao) {
        this.unitDao = unitDao;
        this.unitMissionDao = unitMissionDao;
        this.missionDao = missionDao;
    }

    public void createUnitWithMission(String unitName, String missionName, String location, LocalDate missionDate) {
        Unit unit = new Unit();
        unit.setUnitName(unitName);
        unitDao.save(unit);

        Mission mission = new Mission();
        mission.setMissionName(missionName);
        mission.setLocation(location);
        mission.setMissionDate(missionDate);
        missionDao.save(mission);
        
        UnitMission unitMission = new UnitMission();
        unitMission.setUnit(unit);
        unitMission.setMission(mission);
        unitMissionDao.save(unitMission);

        logger.info("Unit and mission successfully created and linked.");
    }

    public List<UnitMission> getUnitMissions(long unitId) {
        return unitMissionDao.getMissionsByUnitId(unitId);
    }

    public void deleteUnit(long unitId) {
        unitMissionDao.deleteByUnitId(unitId);
        unitDao.removeById(unitId);
        logger.info("Unit and its missions successfully deleted.");
    }
}
