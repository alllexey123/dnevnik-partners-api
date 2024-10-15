package api.dnevnik.partners.model.feed;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import lombok.Data;

@Data
public class ImportantWorkType implements ApiHolder {

    private DnevnikPartnersApi api;

    private long id;

    private String name;

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
    }
}
