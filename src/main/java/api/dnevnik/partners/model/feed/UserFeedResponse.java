package api.dnevnik.partners.model.feed;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import lombok.Data;

import java.util.List;

@Data
public class UserFeedResponse implements ApiHolder {

    private DnevnikPartnersApi api;

    private List<UserFeedDay> days;

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(days);
    }
}
