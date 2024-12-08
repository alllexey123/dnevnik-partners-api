package api.dnevnik.partners.model.user;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import lombok.Data;

@Data
public class Student implements ApiHolder {

    private DnevnikPartnersApi api;

    private Person person;

    @Override
    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.inject(person);
    }
}
