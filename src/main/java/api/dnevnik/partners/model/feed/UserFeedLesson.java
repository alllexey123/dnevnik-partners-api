package api.dnevnik.partners.model.feed;

import lombok.Data;

import java.util.List;

@Data
public class UserFeedLesson {

    private long lessonId;

    private String lessonStatus;

    private int number;

    private String subjectName;

    private List<ImportantWorkType> importantWorkTypes;
}
