package parameterized;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static properties.config.testParameter.SecondExerciseParameters.*;

public class ParameterizedTests {

    protected static List<SecondExerciseParameters> getTableValueParametersByColumnIndex() {
        List<SecondExerciseParameters> secondExerciseParameters = new ArrayList<>();
//        List<List<String>> properties = asList(FIRST_PARAMETER_BY_COLUMN_INDEX, SECOND_PARAMETER_BY_COLUMN_INDEX, THIRD_PARAMETER_BY_COLUMN_INDEX);
        List<List<String>> properties = asList( THIRD_PARAMETER_BY_COLUMN_INDEX);

        properties.forEach(values -> secondExerciseParameters.add(new SecondExerciseParameters(Integer.parseInt(values.get(0)), values.get(1), Integer.parseInt(values.get(2)), values.get(3))));
        return secondExerciseParameters;
    }

    protected static List<SecondExerciseParameters> getTableValueParametersByColumnName() {
        List<SecondExerciseParameters> secondExerciseParameters = new ArrayList<>();
        List<List<String>> properties = asList(FIRST_PARAMETER_BY_COLUMN_NAME, SECOND_PARAMETER_BY_COLUMN_NAME, THIRD_PARAMETER_BY_COLUMN_NAME);
        properties.forEach(values -> secondExerciseParameters.add(new SecondExerciseParameters(values.get(0), values.get(1), Integer.parseInt(values.get(2)), values.get(3))));
        return secondExerciseParameters;
    }
}
