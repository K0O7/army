package solvd;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import daos.myBatis.IMissionDao;
import daos.myBatis.IUnitDao;
import daos.myBatis.IUnitMissionDao;
import daos.myBatis.MissionDao;
import daos.myBatis.UnitDao;
import daos.myBatis.UnitMissionDao;
import daos.mySqlImp.SoldierDao;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import solvd.army.MissionJson;
import solvd.army.Soldier;
import solvd.army.Unit;
import solvd.army.UnitJson;
import solvd.army.UnitMission;
import solvd.army.UnitMissionJson;
import solvd.army.UnitWBuilder;
import solvd.army.decorators.BasicSoldier;
import solvd.army.decorators.GrenadierSoldier;
import solvd.army.decorators.ISoldier;
import solvd.army.decorators.SniperSoldier;
import solvd.army.facade.UnitServiceFacade;
import solvd.army.factory.AirforceFactory;
import solvd.army.factory.IArmyFactory;
import solvd.army.factory.IMission;
import solvd.army.factory.IUnit;
import solvd.army.factory.InfantryFactory;
import solvd.army.factory.UnitFactory;
import solvd.army.listeners.UnitLoggerListener;
import solvd.army.mvc.UnitController;
import solvd.army.mvc.UnitMVC;
import solvd.army.mvc.UnitView;
import solvd.army.proxy.MissionProxy;
import solvd.army.strategy.MeleeAttack;
import solvd.army.strategy.RangedAttack;
import solvd.army.strategy.SoldierUnit;
import solvd.army.strategy.StealthAttack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * SOLID
 * S - classes like ConnectionPool, MyBatisUtil, Soldier or SoldierDao have single responsibility and only one reason to change
 * O - patterns like Strategy or Proxy provide abilyty to change class behaviour at runtime withot modifying their code so classes implementing them are open to extension but closed to modification
 * L - Classes like AbstractMySqlDao satisfy the LSP
 * I - all classes implementing interface form Dao hierarchy satisfy ISP
 * D - Classes like AbstractMySqlDao, implementing Proxy pattern satisfy DIP
 */

public class run {
	
	private static final Logger logger = LogManager.getLogger(run.class);

	public static void main(String[] args) throws IOException {
		//can change databeses using ex. ConnectionPool.configureDatabase("oracle", "jdbc:oracle:thin:@localhost:1521:orcl", "oracleUser", "oraclePassword");
		//rest of this code stays the same doesnt matter which database, just neet to include it in connectionPool class		
        // standard daos -------------------------------------------------------------------------------------
		SoldierDao soldierDao = new SoldierDao();

        // Insert a new soldier
        Soldier newSoldier = new Soldier(1L, "John", "Doe");
        soldierDao.save(newSoldier);

        // Get soldier by ID
        Soldier soldier = soldierDao.getById(1L);
        if (soldier != null) {
        	logger.info("Retrieved: " + soldier.getFirstName() + " " + soldier.getLastName());
        }

        // Update soldier
        soldier.setFirstName("Jonathan");
        soldierDao.update(soldier);

        // Remove soldier
        soldierDao.removeById(1L);
        
        //xml xsd validation and parser------------------------------------------------------
        
        String xmlFile = "soldier.xml";
        String xsdFile = "soldier.xsd";

        if (validateXML(xmlFile, xsdFile)) {
        	logger.info("✅ XML is valid.\n");
        } else {
        	logger.info("❌ XML is NOT valid.\n");
        }
        
        ArmyDataDOMParser.parseSoldiers("soldier.xml");
        ArmyDataDOMParser.parseRanks("rank.xml");
        ArmyDataDOMParser.parseAllergies("allergy.xml");
        ArmyDataDOMParser.parseSoldierTrainings("soldierTraining.xml");
        ArmyDataDOMParser.parseTrainingPrograms("trainingProgram.xml");
        
        // jaxD -------------------------------------------------------------------------------------
        
        xmlFile = "soldierJAXA.xml";
        soldier = parseSoldierXML(xmlFile);

        if (soldier != null) {
        	logger.info("Parsed Soldier: " + soldier.getFirstName() + " " + soldier.getRank().getRankName() + " " + soldier.getTrainings().get(0).getTrainingProgram().getProgramName() + ", " + soldier.getTrainings().get(1).getTrainingProgram().getProgramName());
        } else {
        	logger.info("Failed to parse XML.");
        }
        
        //jackson-----------------------------------------------------------
        
        UnitMissionJson unitMission = new UnitMissionJson();
        UnitJson unit = new UnitJson();
        MissionJson mission = new MissionJson();
        unit.setId(101);
        unit.setUnitName("infantry");
        List<UnitMissionJson> missions = new ArrayList<UnitMissionJson>();
        missions.add(unitMission);
        unit.setUnitMissions(missions);
        mission.setId(201);
        mission.setLocation("Poland");
        mission.setMissionDate(null);
        mission.setMissionName("exercise");
        unitMission.setId(301);
        unitMission.setMission(mission);
        unitMission.setUnit(unit);
        
        //JsonParser.writeJson("mission.json", mission);
        //JsonParser.writeJson("unitMission.json", unitMission);
        //JsonParser.writeJson("unit.json", unit);
        
        //myBatis--------------------------------------------------------------------------------
        IUnitDao unitDao = new UnitDao();

        // Fetch unit by ID
        logger.info("Unit Name: " + unit.getUnitName());

        // Insert new unit
        Unit newUnit = new Unit();
        newUnit.setUnitName("Elite Squad");
        unitDao.save(newUnit);
        logger.info("Inserted Unit ID: " + newUnit.getId());

        // Update unit
        newUnit.setUnitName("Updated Squad");
        unitDao.update(newUnit);
        logger.info("Updated Unit Name: " + newUnit.getUnitName());

        // Remove unit
        unitDao.removeById(newUnit.getId());
        logger.info("Unit deleted.");
        
        //factory---------------------------------------------------------------------------------
        
        IUnit infantry = UnitFactory.createUnit("infantry");
        infantry.displayInfo();

        IUnit airforce = UnitFactory.createUnit("airforce");
        airforce.displayInfo();
        
        //abstract factory--------------------------------------------------------------------------
        IArmyFactory infantryFactory = new InfantryFactory();
        IUnit infantry2 = infantryFactory.createUnit();
        IMission infantryMission = infantryFactory.createMission();
        
        infantry2.displayInfo();
        infantryMission.execute();

        IArmyFactory airforceFactory = new AirforceFactory();
        IUnit airforce2 = airforceFactory.createUnit();
        IMission airforceMission = airforceFactory.createMission();

        airforce2.displayInfo();
        airforceMission.execute();
        
        //builder ------------------------------------------------------------
        
        UnitWBuilder infantryUnit = new UnitWBuilder.UnitBuilder()
                .setId(1)
                .setUnitName("Infantry Division")
                .setUnitMissions(List.of(new UnitMission(101, null, null)))
                .build();

        logger.info("Created Unit: " + infantryUnit.getUnitName());
        
        //Listener------------------------------------------------------------------ 
        daos.mySqlImp.UnitDao unitDao2 = new daos.mySqlImp.UnitDao();
        
        unitDao2.addListener(new UnitLoggerListener());

        Unit newUnit2 = new Unit();
        newUnit2.setId(1);
        newUnit2.setUnitName("Infantry Division");
        logger.info(newUnit.getUnitName());
        unitDao2.save(newUnit2);

        newUnit2 = new Unit();
        newUnit2.setId(1);
        newUnit2.setUnitName("Special Forces");
        unitDao2.update(newUnit2);

        unitDao2.removeById(1);
        
        //Facade------------------------------------------------------------------ 
        IUnitDao unitDao3 = new UnitDao();
        IUnitMissionDao unitMissionDao = new UnitMissionDao();
        IMissionDao missionDao = new MissionDao();
        LocalDate localdate = LocalDate.now(); 
        UnitServiceFacade facade = new UnitServiceFacade(unitDao3, unitMissionDao, missionDao);

        facade.createUnitWithMission("Infantry Division", "Operation Storm", "Desert Base", localdate);

        facade.getUnitMissions(1).forEach(um ->
        		logger.info("Unit Mission: " + um.getMission().getMissionName()));

        facade.deleteUnit(1);
        
        
        //Decorator------------------------------------------------------------------ 
        
        ISoldier basicSoldier = new BasicSoldier();
        logger.info("Basic Soldier:");
        basicSoldier.attack();

        ISoldier sniper = new SniperSoldier(new BasicSoldier());
        logger.info("Sniper Soldier:");
        sniper.attack();

        ISoldier grenadier = new GrenadierSoldier(new BasicSoldier());
        logger.info("Grenadier Soldier:");
        grenadier.attack();

        ISoldier elite = new SniperSoldier(new GrenadierSoldier(new BasicSoldier()));
        logger.info("Elite Soldier (Sniper + Grenadier):");
        elite.attack();
        
        //Proxy------------------------------------------------------------------ 
        solvd.army.proxy.IMission unauthorizedMission = new MissionProxy("Operation Blackout", false);
        unauthorizedMission.executeMission();  // Should print "ACCESS DENIED"

        solvd.army.proxy.IMission authorizedMission = new MissionProxy("Operation Blackout", true);
        authorizedMission.executeMission();  // Should execute the mission
        
        
        //Strategy------------------------------------------------------------------ 
        SoldierUnit soldierUnit = new SoldierUnit("Infantry", new MeleeAttack());
        soldierUnit.executeAttack();

        soldierUnit.setAttackStrategy(new RangedAttack());
        soldierUnit.executeAttack();

        SoldierUnit spy = new SoldierUnit("Special Ops", new StealthAttack());
        spy.executeAttack();
        
        //MVC ------------------------------------------------------------------
        UnitMVC unitMvc = new UnitMVC(1, "Alpha Squad");

        // View
        UnitView view = new UnitView();

        // Controller
        UnitController controller = new UnitController(unitMvc, view);

        // Initial display
        controller.updateView();

        // Modify unit name
        controller.setUnitName("Bravo Squad");

        // Update view
        controller.updateView();
        
        
	}
	
	public static boolean validateXML(String xmlFileName, String xsdFileName) {
	    try {
	        // Load files from resources folder
	        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	        InputStream xmlInput = classLoader.getResourceAsStream(xmlFileName);
	        InputStream xsdInput = classLoader.getResourceAsStream(xsdFileName);

	        if (xmlInput == null) {
	            System.err.println("❌ XML file not found: " + xmlFileName);
	            return false;
	        }
	        if (xsdInput == null) {
	            System.err.println("❌ XSD file not found: " + xsdFileName);
	            return false;
	        }

	        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	        Schema schema = factory.newSchema(new StreamSource(xsdInput));
	        Validator validator = schema.newValidator();
	        validator.validate(new StreamSource(xmlInput));

	        return true;
	    } catch (SAXException | IOException e) {
	        System.err.println("❌ Validation error: " + e.getMessage());
	        e.printStackTrace();
	        return false;
	    }
	}

    public static Soldier parseSoldierXML(String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(Soldier.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Load the file as a resource
            ClassLoader classLoader = run.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(fileName);

            if (inputStream == null) {
                throw new IllegalArgumentException("File not found: " + fileName);
            }

            return (Soldier) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException | IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }
}