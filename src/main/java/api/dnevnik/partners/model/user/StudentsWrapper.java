package api.dnevnik.partners.model.user;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import lombok.Data;

import java.util.List;

@Data
public class StudentsWrapper implements ApiHolder {

    private DnevnikPartnersApi api;

    private EduGroup group;

    private List<Student> students;

    @Override
    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.inject(group);
        api.injectMany(students);
    }
}
