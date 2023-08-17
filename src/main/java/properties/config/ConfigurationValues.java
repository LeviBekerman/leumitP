package properties.config;

import utils.files.fileReder.PropertiesFileReader;

public class ConfigurationValues {

    private static final String GENERAL_CONFIG_PATH = "config/generalConfig.yaml";
    private static final PropertiesFileReader propertiesFileReader = new PropertiesFileReader(GENERAL_CONFIG_PATH);


    // Selenium
    public static final int SELENIUM_IMPLICIT_WAIT_IN_SECONDS = propertiesFileReader.getIntProperty("selenium_default_implicit_wait_in_seconds");
    public static final int SELENIUM_EXPLICIT_WAIT_IN_SECONDS = propertiesFileReader.getIntProperty("selenium_default_explicit_wait_in_seconds");
    public static final int DEFAULT_AWAITER_INTERVAL_IN_MILLIS = propertiesFileReader.getIntProperty("default_awaiter_interval_in_millis");

    // One exercise
    public static final String FIRST_EXERCISE_URL = propertiesFileReader.getProperty("first_exercise_url");

    // Second exercise
    public static final String SECOND_EXERCISE_URL = propertiesFileReader.getProperty("second_exercise_url");

}
