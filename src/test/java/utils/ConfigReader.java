package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final String CONFIG_FILE = "config/config.properties";
    private static final Properties PROPERTIES = loadProperties();

    private ConfigReader() {
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();

        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (inputStream == null) {
                throw new IllegalStateException("Configuration file not found: " + CONFIG_FILE);
            }
            properties.load(inputStream);
            return properties;
        } catch (IOException exception) {
            throw new IllegalStateException("Failed to load configuration file: " + CONFIG_FILE, exception);
        }
    }

    public static String getRequiredProperty(String key) {
        String value = PROPERTIES.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing required property: " + key);
        }
        return value.trim();
    }

    public static long getDurationSeconds(String key) {
        return Long.parseLong(getRequiredProperty(key));
    }
}
