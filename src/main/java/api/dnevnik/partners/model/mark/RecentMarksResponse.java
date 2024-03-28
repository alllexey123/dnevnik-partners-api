package api.dnevnik.partners.model.mark;

import api.dnevnik.partners.model.work.LessonLogEntry;
import api.dnevnik.partners.model.work.*;
import lombok.Data;

import java.util.List;

@Data
public class RecentMarksResponse {

    private List<Mark> marks;

    private List<Work> works;

    private List<WorkType> workTypes;

    private List<Subject> subjects;

    private List<Lesson> lessons;

    private List<LessonLogEntry> lessonLogEntries;
}
