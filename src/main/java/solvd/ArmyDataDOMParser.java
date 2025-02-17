package solvd;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class ArmyDataDOMParser {

    public static void parseSoldiers(String filePath) {
        System.out.println("Soldiers:");
        Document document = parseXMLFile(filePath);
        if (document == null) return;

        NodeList soldierList = document.getElementsByTagName("Soldier");
        for (int i = 0; i < soldierList.getLength(); i++) {
            Element soldier = (Element) soldierList.item(i);
            System.out.println("  ID: " + soldier.getAttribute("id"));
            System.out.println("  First Name: " + soldier.getElementsByTagName("first_name").item(0).getTextContent());
            System.out.println("  Last Name: " + soldier.getElementsByTagName("last_name").item(0).getTextContent());
            System.out.println();
        }
    }

    public static void parseRanks(String filePath) {
        System.out.println("Ranks:");
        Document document = parseXMLFile(filePath);
        if (document == null) return;

        NodeList rankList = document.getElementsByTagName("Rank");
        for (int i = 0; i < rankList.getLength(); i++) {
            Element rank = (Element) rankList.item(i);
            System.out.println("  ID: " + rank.getElementsByTagName("id").item(0).getTextContent());
            System.out.println("  Rank Name: " + rank.getElementsByTagName("rank_name").item(0).getTextContent());
            System.out.println("  Soldier ID: " + rank.getElementsByTagName("soldier_id").item(0).getTextContent());
            System.out.println();
        }
    }

    public static void parseAllergies(String filePath) {
        System.out.println("Allergies:");
        Document document = parseXMLFile(filePath);
        if (document == null) return;

        NodeList allergyList = document.getElementsByTagName("Allergy");
        for (int i = 0; i < allergyList.getLength(); i++) {
            Element allergy = (Element) allergyList.item(i);
            System.out.println("  ID: " + allergy.getElementsByTagName("id").item(0).getTextContent());
            System.out.println("  Medical Record ID: " + allergy.getElementsByTagName("medical_record_id").item(0).getTextContent());
            System.out.println("  Allergen: " + allergy.getElementsByTagName("allergen").item(0).getTextContent());
            System.out.println();
        }
    }

    public static void parseSoldierTrainings(String filePath) {
        System.out.println("Soldier Trainings:");
        Document document = parseXMLFile(filePath);
        if (document == null) return;

        NodeList trainingList = document.getElementsByTagName("SoldierTraining");
        for (int i = 0; i < trainingList.getLength(); i++) {
            Element training = (Element) trainingList.item(i);
            System.out.println("  ID: " + training.getElementsByTagName("id").item(0).getTextContent());
            System.out.println("  Soldier ID: " + training.getElementsByTagName("soldier_id").item(0).getTextContent());
            System.out.println("  Training Program ID: " + training.getElementsByTagName("training_program_id").item(0).getTextContent());
            System.out.println("  Start Date: " + training.getElementsByTagName("start_date").item(0).getTextContent());
            System.out.println("  End Date: " + training.getElementsByTagName("end_date").item(0).getTextContent());
            System.out.println();
        }
    }

    public static void parseTrainingPrograms(String filePath) {
        System.out.println("Training Programs:");
        Document document = parseXMLFile(filePath);
        if (document == null) return;

        NodeList programList = document.getElementsByTagName("TrainingProgram");
        for (int i = 0; i < programList.getLength(); i++) {
            Element program = (Element) programList.item(i);
            System.out.println("  ID: " + program.getElementsByTagName("id").item(0).getTextContent());
            System.out.println("  Program Name: " + program.getElementsByTagName("program_name").item(0).getTextContent());
            System.out.println();
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
            System.out.println("Error parsing " + fileName + ": " + e.getMessage());
            return null;
        }
    }
}
