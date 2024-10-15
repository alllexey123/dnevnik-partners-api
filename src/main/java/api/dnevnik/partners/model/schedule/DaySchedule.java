package api.dnevnik.partners.model.schedule;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.mark.Mark;
import api.dnevnik.partners.model.work.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class DaySchedule implements ApiHolder {

    private DnevnikPartnersApi api;

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

    @Override
    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(lessons);
        api.injectMany(marks);
        api.injectMany(works);
        api.injectMany(homeworks);
        api.injectMany(subjects);
        api.injectMany(lessonLogEntries);
    }
}
