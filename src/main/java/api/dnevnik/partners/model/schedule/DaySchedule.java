package api.dnevnik.partners.model.schedule;

import api.dnevnik.partners.model.mark.Mark;
import api.dnevnik.partners.model.work.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class DaySchedule {

    private OffsetDateTime date;

    private List<Lesson> lessons;

    private List<Mark> marks;

    private List<Work> works;

    private List<Work> homeworks;

    private List<Subject> subjects;

    private List<WorkType> workTypes;

    private List<LessonLogEntry> lessonLogEntries;

    private List<DayScheduleTeacher> teachers;

    private OffsetDateTime nextDate;
}
