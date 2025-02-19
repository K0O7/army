package solvd;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArmyDataDOMParser {
	private static final Logger logger = LogManager.getLogger(ArmyDataDOMParser.class);

    public static void parseSoldiers(String filePath) {
    	logger.info("Soldiers:");
        Document document = parseXMLFile(filePath);
        if (document == null) return;

        NodeList soldierList = document.getElementsByTagName("Soldier");
        for (int i = 0; i < soldierList.getLength(); i++) {
            Element soldier = (Element) soldierList.item(i);
            logger.info("  ID: " + soldier.getAttribute("id"));
            logger.info("  First Name: " + soldier.getElementsByTagName("first_name").item(0).getTextContent());
            logger.info("  Last Name: " + soldier.getElementsByTagName("last_name").item(0).getTextContent());
        }
    }

    public static void parseRanks(String filePath) {
    	logger.info("Ranks:");
        Document document = parseXMLFile(filePath);
        if (document == null) return;

        NodeList rankList = document.getElementsByTagName("Rank");
        for (int i = 0; i < rankList.getLength(); i++) {
            Element rank = (Element) rankList.item(i);
            logger.info("  ID: " + rank.getElementsByTagName("id").item(0).getTextContent());
            logger.info("  Rank Name: " + rank.getElementsByTagName("rank_name").item(0).getTextContent());
            logger.info("  Soldier ID: " + rank.getElementsByTagName("soldier_id").item(0).getTextContent());
        }
    }

    public static void parseAllergies(String filePath) {
    	logger.info("Allergies:");
        Document document = parseXMLFile(filePath);
        if (document == null) return;

        NodeList allergyList = document.getElementsByTagName("Allergy");
        for (int i = 0; i < allergyList.getLength(); i++) {
            Element allergy = (Element) allergyList.item(i);
            logger.info("  ID: " + allergy.getElementsByTagName("id").item(0).getTextContent());
            logger.info("  Medical Record ID: " + allergy.getElementsByTagName("medical_record_id").item(0).getTextContent());
            logger.info("  Allergen: " + allergy.getElementsByTagName("allergen").item(0).getTextContent());
        }
    }

    public static void parseSoldierTrainings(String filePath) {
    	logger.info("Soldier Trainings:");
        Document document = parseXMLFile(filePath);
        if (document == null) return;

        NodeList trainingList = document.getElementsByTagName("SoldierTraining");
        for (int i = 0; i < trainingList.getLength(); i++) {
            Element training = (Element) trainingList.item(i);
            logger.info("  ID: " + training.getElementsByTagName("id").item(0).getTextContent());
            logger.info("  Soldier ID: " + training.getElementsByTagName("soldier_id").item(0).getTextContent());
            logger.info("  Training Program ID: " + training.getElementsByTagName("training_program_id").item(0).getTextContent());
            logger.info("  Start Date: " + training.getElementsByTagName("start_date").item(0).getTextContent());
            logger.info("  End Date: " + training.getElementsByTagName("end_date").item(0).getTextContent());
        }
    }

    public static void parseTrainingPrograms(String filePath) {
    	logger.info("Training Programs:");
        Document document = parseXMLFile(filePath);
        if (document == null) return;

        NodeList programList = document.getElementsByTagName("TrainingProgram");
        for (int i = 0; i < programList.getLength(); i++) {
            Element program = (Element) programList.item(i);
            logger.info("  ID: " + program.getElementsByTagName("id").item(0).getTextContent());
            logger.info("  Program Name: " + program.getElementsByTagName("program_name").item(0).getTextContent());
        }
    }

    private static Document parseXMLFile(String fileName) {
        try {
            ClassLoader classLoader = ArmyDataDOMParser.class.getClassLoader();
            if (classLoader == null) {
                throw new RuntimeException("ClassLoader is null!");
            }

            java.net.URL resource = classLoader.getResource(fileName);
            if (resource == null) {
                throw new RuntimeException("File not found in resources: " + fileName);
            }

            File file = new File(resource.toURI());

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception e) {
        	logger.error("Error parsing " + fileName + ": " + e.getMessage());
            return null;
        }
    }
}
