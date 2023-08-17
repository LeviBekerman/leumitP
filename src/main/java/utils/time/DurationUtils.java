package utils.time;

import java.time.Duration;

import static org.apache.commons.lang3.time.DurationFormatUtils.formatDurationWords;

public class DurationUtils {
    public static String getDurationByHumanReadAble(Duration duration){
        return formatDurationWords(duration.toMillis(), true, true);
    }
}
