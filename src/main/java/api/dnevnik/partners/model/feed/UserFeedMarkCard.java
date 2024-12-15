package api.dnevnik.partners.model.feed;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.mark.Mark;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class UserFeedMarkCard implements ApiHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private List<Mark> marks;

    private TinyLesson lesson;

    private boolean isImportant;

    private String subjectName;

    private long subjectId;

    private String workTypeName;

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(marks);
    }
}
