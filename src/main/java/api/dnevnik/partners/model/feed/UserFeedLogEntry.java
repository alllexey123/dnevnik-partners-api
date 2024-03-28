package api.dnevnik.partners.model.feed;

import api.dnevnik.partners.model.work.LessonLogEntry;
import lombok.Data;

@Data
public class UserFeedLogEntry {

    private LessonLogEntry lessonLogEntry;

    private String subjectName;

    private String lessonTitle;
}
