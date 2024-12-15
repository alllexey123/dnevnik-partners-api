package api.dnevnik.partners.model.feed;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class UserFeedLesson implements ApiHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private long lessonId;

    private String lessonStatus;

    private int number;

    private String subjectName;

    private List<ImportantWorkType> importantWorkTypes;

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(importantWorkTypes);
    }
}
