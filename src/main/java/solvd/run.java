package solvd;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import daos.mySqlImp.SoldierDao;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import solvd.army.*;
import daos.myBatis.*;

public class run {

	public static void main(String[] args) throws IOException {
		//can change databeses using ex. ConnectionPool.configureDatabase("oracle", "jdbc:oracle:thin:@localhost:1521:orcl", "oracleUser", "oraclePassword");
		//rest of this code stays the same doesnt matter which database, just neet to include it in connectionPool class		
        SoldierDao soldierDao = new SoldierDao();

        // Insert a new soldier
        Soldier newSoldier = new Soldier(1L, "John", "Doe");
        soldierDao.save(newSoldier);

        // Get soldier by ID
        Soldier soldier = soldierDao.getById(1L);
        if (soldier != null) {
        	//logger.info("Retrieved: " + soldier.getFirstName() + " " + soldier.getLastName());
        }

        // Update soldier
        soldier.setFirstName("Jonathan");
        soldierDao.update(soldier);

        // Remove soldier
        soldierDao.removeById(1L);
        
        String xmlFile = "soldier.xml";
        String xsdFile = "soldier.xsd";

        if (validateXML(xmlFile, xsdFile)) {
        	System.out.print("✅ XML is valid.\n");
        } else {
        	System.out.print("❌ XML is NOT valid.\n");
        }
        
        ArmyDataDOMParser.parseSoldiers("soldier.xml");
        ArmyDataDOMParser.parseRanks("rank.xml");
        ArmyDataDOMParser.parseAllergies("allergy.xml");
        ArmyDataDOMParser.parseSoldierTrainings("soldierTraining.xml");
        ArmyDataDOMParser.parseTrainingPrograms("trainingProgram.xml");
        
        xmlFile = "soldierJAXA.xml"; // Update the path if needed
        soldier = parseSoldierXML(xmlFile);

        if (soldier != null) {
            System.out.println("Parsed Soldier: " + soldier.getFirstName() + " " + soldier.getRank().getRankName() + " " + soldier.getTrainings().get(0).getTrainingProgram().getProgramName() + ", " + soldier.getTrainings().get(1).getTrainingProgram().getProgramName());
        } else {
            System.out.println("Failed to parse XML.");
        }
        
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
        
        IUnitDao unitDao = new UnitDao();

        // Fetch unit by ID
        Unit unit2 = unitDao.getById(1);
        System.out.println("Unit Name: " + unit.getUnitName());

        // Insert new unit
        Unit newUnit = new Unit();
        newUnit.setUnitName("Elite Squad");
        unitDao.save(newUnit);
        System.out.println("Inserted Unit ID: " + newUnit.getId());

        // Update unit
        newUnit.setUnitName("Updated Squad");
        unitDao.update(newUnit);
        System.out.println("Updated Unit Name: " + newUnit.getUnitName());

        // Remove unit
        unitDao.removeById(newUnit.getId());
        System.out.println("Unit deleted.");

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


/*
uwagi
jak robienie adnotacji do JAXB, Jackson, itd robi kopie klasy z innymi adnotacjami

pytania
czy taki wrapper jest dobry(abstractMySqlDao)?
jak najlepiej łączyc klasy stworzone w osobnych dao?, jako metoda osobnej klasy? czy w jednym z dao przez przekazanie odpowiednich info? czy SoldierDao powinien wywolywac metody do znalezienia odpowiednich danych z innych dao?

todo
Add Factory, Abstract Factory, Builder, Listener, Facade, Decorator, Proxy, Strategy, MVC patterns to your current project.
Refactor code for the current project to satisfy SOLID principles.
*/