package api.dnevnik.partners.model.schedule;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.user.Person;
import lombok.Data;

@Data
public class DayScheduleTeacher implements ApiHolder {

    private DnevnikPartnersApi api;

    private Person person;

    private String role;

    @Override
    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.inject(person);
    }
}
