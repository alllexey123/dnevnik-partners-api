package api.dnevnik.partners.model.schedule;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Timetable {

    private String Name;

    private LocalDateTime Start;

    private int FirstLessonNumber;

    private List<TimetableItem> Items;
}

