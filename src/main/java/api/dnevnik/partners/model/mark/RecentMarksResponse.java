package api.dnevnik.partners.model.mark;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.work.LessonLogEntry;
import api.dnevnik.partners.model.work.*;
import lombok.Data;

import java.util.List;

@Data
public class RecentMarksResponse implements ApiHolder {

    private DnevnikPartnersApi api;

    private List<Mark> marks;

    private List<Work> works;

    private List<WorkType> workTypes;

    private List<Subject> subjects;

    private List<Lesson> lessons;

    private List<LessonLogEntry> lessonLogEntries;

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(marks);
        api.injectMany(works);
        api.injectMany(subjects);
        api.injectMany(lessons);
        api.injectMany(lessonLogEntries);
    }
}
