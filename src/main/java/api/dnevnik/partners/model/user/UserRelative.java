package api.dnevnik.partners.model.user;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import lombok.Data;

@Data
public class UserRelative implements ApiHolder {

    private DnevnikPartnersApi api;

    private String type;

    private Person person;

    @Override
    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.inject(person);
    }
}
