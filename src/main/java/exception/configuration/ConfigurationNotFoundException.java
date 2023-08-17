package exception.configuration;

public class ConfigurationNotFoundException extends RuntimeException {
    public ConfigurationNotFoundException(String propertyName, String filePath) {
        super("Property '" + propertyName + "' not found in '" + filePath + "'");
    }
}
