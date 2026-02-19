package UtilityPackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	//Static methods : Belong to the class, not objects. Can be called without creating an instance.
    // Static: shared across all uses, loaded only once
    // Holds all configuration key-value pairs from the file
    private static Properties prop;

    // Private: helper method, only used inside this class
    // Loads the properties file into memory
    private static void loadProperties() {
        // Only load once
        if (prop == null) {
            // try-with-resources ensures InputStream is automatically closed
            try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {

                // If file not found, throw an exception (can't continue without config)
                if (input == null) {
                    throw new RuntimeException("config.properties file not found in resources");
                }

                // Properties class: designed to hold key-value pairs from .properties files
                prop = new Properties();
                prop.load(input); // Load all key-value pairs into memory

            } catch (IOException e) {
                // try-catch handles exceptions from file reading
                // Wrap in RuntimeException to stop program with a meaningful message
                throw new RuntimeException("Failed to load config.properties file", e);
            }
        }
    }

    // Public: method other classes can use to get configuration values
    public static String getProperty(String key) {
        loadProperties(); // Ensure file is loaded
        String value = prop.getProperty(key); // Get value from Properties

        // If key is missing, throw an exception
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in config.properties");
        }

        return value; // Return the value
    }
}
