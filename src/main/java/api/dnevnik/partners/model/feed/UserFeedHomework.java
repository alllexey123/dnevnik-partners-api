package api.dnevnik.partners.model.feed;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.work.Work;
import lombok.Data;

@Data
public class UserFeedHomework implements ApiHolder {

    private DnevnikPartnersApi api;

    private Work work;

    private String subjectName;

    private String workTypeName;

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.inject(work);
    }
}
