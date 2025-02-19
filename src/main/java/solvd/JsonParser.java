package solvd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JsonParser {
	private static final Logger logger = LogManager.getLogger(JsonParser.class);
	
    public static <T> T parseJson(String filePath, Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            
            return objectMapper.readValue(new File(filePath), clazz);
        } catch (IOException e) {
        	logger.error(e.toString());
            return null;
        }
    }

    public static <T> void writeJson(String filePath, T object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), object);
            logger.info("JSON file created: " + filePath);
        } catch (IOException e) {
        	logger.error(e.toString());
        }
    }
}
