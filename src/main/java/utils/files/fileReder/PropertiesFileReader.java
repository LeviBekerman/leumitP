package utils.files.fileReder;

import exception.configuration.ConfigurationNotFoundException;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import static java.lang.Boolean.getBoolean;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class PropertiesFileReader {

    private final String propertyFilePath;
    private final Properties properties = new Properties();

    @SneakyThrows
    public PropertiesFileReader(String propertyFilePath) {
        this.propertyFilePath = propertyFilePath;
        properties.load(new FileReader(propertyFilePath));
    }

    public String getProperty(String propertyName) {
        return Optional.ofNullable(properties.getProperty(propertyName)).orElseThrow(() -> new ConfigurationNotFoundException(propertyName, propertyFilePath));
    }

    public int getIntProperty(String propertyName) {
        return parseInt(getProperty(propertyName));
    }

    public boolean getBooleanProperty(String propertyName) {
        return getBoolean(getProperty(propertyName));
    }

    public List<String> getListProperty(String propertyName, String separatorBy) {
        String properties = getProperty(propertyName);
        return properties.isEmpty() ? emptyList() : asList(properties.split(separatorBy));
    }
}
