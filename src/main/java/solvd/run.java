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

import daos.mySqlImp.SoldierDao;
import solvd.army.Soldier;

public class run {

	public static void main(String[] args) {
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



}


/*

uwagi
jak robienie adnotacji do JAXD, Jackson, itd robi kopie klasy z innymi adnotacjami

pytania
czy taki wrapper jest dobry(abstractMySqlDao)?
jak najlepiej łączyc klasy stworzone w osobnych dao?, jako metoda osobnej klasy? czy w jednym z dao przez przekazanie odpowiednich info? czy SoldierDao powinien wywolywac metody do znalezienia odpowiednich danych z innych dao?

todo
Validate XML file using XSD schema and assigned parser. done
Parse XML file using one of the parsers from the title. used DOM
*/