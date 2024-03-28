package api.dnevnik.partners.model.schedule;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TimetableItem {

    private long Id;

    private LocalDateTime Start;

    private LocalDateTime Finish;

    private String Name;

    private String Type;

    private List<String> DaysOfWeek;

    private int LessonNumber;
}
