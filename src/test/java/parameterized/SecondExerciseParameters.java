package parameterized;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SecondExerciseParameters {
    int searchColumn;
    String searchText;
    int returnColumnText;
    String exceptedValue;
}
