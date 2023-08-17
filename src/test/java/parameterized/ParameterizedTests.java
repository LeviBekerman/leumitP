package parameterized;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static properties.config.testParameter.SecondExerciseParameters.*;

public class ParameterizedTests {

    protected static List<SecondExerciseParameters> getTableValueParameters() {
        List<SecondExerciseParameters> secondExerciseParameters = new ArrayList<>();
        List<List<String>> properties = asList(FIRST_PARAMETER, SECOND_PARAMETER, THIRD_PARAMETER);
        properties.forEach(values -> secondExerciseParameters.add(new SecondExerciseParameters(Integer.parseInt(values.get(0)), values.get(1), Integer.parseInt(values.get(2)), values.get(3))));
        return secondExerciseParameters;
    }
}
