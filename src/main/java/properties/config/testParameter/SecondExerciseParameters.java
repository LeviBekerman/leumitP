package properties.config.testParameter;

import utils.files.fileReder.PropertiesFileReader;

import java.util.List;

public class SecondExerciseParameters {
    private static final String PATH = "config/secondExercise.yaml";

    private static final PropertiesFileReader propertiesFileReader = new PropertiesFileReader(PATH);

    public static List<String> FIRST_PARAMETER = propertiesFileReader.getListProperty("first.parameter", ",");
    public static List<String> SECOND_PARAMETER = propertiesFileReader.getListProperty("second.parameter", ",");
    public static List<String> THIRD_PARAMETER = propertiesFileReader.getListProperty("third.parameter", ",");


}
