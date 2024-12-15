package api.dnevnik.partners.model.feed;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.work.LessonLogEntry;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class UserFeedLogEntry implements ApiHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private LessonLogEntry lessonLogEntry;

    private String subjectName;

    private String lessonTitle;

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.inject(lessonLogEntry);
    }
}
