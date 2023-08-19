package properties.config.testParameter;

import utils.files.fileReder.PropertiesFileReader;

import java.util.List;

public class SecondExerciseParameters {
    private static final String PATH = "config/secondExercise.yaml";

    private static final PropertiesFileReader propertiesFileReader = new PropertiesFileReader(PATH);

    public static List<String> FIRST_PARAMETER_BY_COLUMN_INDEX = propertiesFileReader.getListProperty("first.parameter.by.column.index", ",");
    public static List<String> SECOND_PARAMETER_BY_COLUMN_INDEX = propertiesFileReader.getListProperty("second.parameter.by.column.index", ",");
    public static List<String> THIRD_PARAMETER_BY_COLUMN_INDEX = propertiesFileReader.getListProperty("third.parameter.by.column.index", ",");

    public static List<String> FIRST_PARAMETER_BY_COLUMN_NAME = propertiesFileReader.getListProperty("first.parameter.by.column.name", ",");
    public static List<String> SECOND_PARAMETER_BY_COLUMN_NAME = propertiesFileReader.getListProperty("second.parameter.by.column.name", ",");
    public static List<String> THIRD_PARAMETER_BY_COLUMN_NAME = propertiesFileReader.getListProperty("third.parameter.by.column.name", ",");

}
