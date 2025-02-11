package solvd;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
import java.io.IOException;

import daos.mySqlImp.SoldierDao;
import solvd.army.Soldier;

public class run {

	public static void main(String[] args) {
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
        //soldierDao.removeById(1L);
        
        String xmlFile = "soldier.xml";
        String xsdFile = "soldier.xsd";

        if (validateXML(xmlFile, xsdFile)) {
        	//logger.info("✅ XML is valid.");
        } else {
        	//logger.info("❌ XML is NOT valid.");
        }

	}
	
    public static boolean validateXML(String xmlFile, String xsdFile) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdFile));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFile)));
            return true;
        } catch (SAXException | IOException e) {
        	//logger.severe("Validation error: " + e.getMessage());
            return false;
        }
    }

}


/*
pytania
dobra struktura? dobra
jak lepiej hierarchie klas zapisac? dobrze jest jak teraz
co w klasie abstractMySqlDao to wrapper dla serwisu, powinien umożliwiac zmiany servisu bez potrzeby wywoływania zupełnie innych metod na poziomie maina
jak najlepiej implementowac wspieranie innych baz danych? w abstractmysqlDao i odpowiednikach dla innych
czy dao do wszystkich implementowac?  około 5 wystarczy
jak robienie adnotacji do JAXD, Jackson, itd robi kopie klasy z innymi adnotacjami

todo
Implement Service layer with necessary abstraction to be able to switch between databases and frameworks.
Validate XML file using XSD schema and assigned parser.
Parse XML file using one of the parsers from the title.
*/