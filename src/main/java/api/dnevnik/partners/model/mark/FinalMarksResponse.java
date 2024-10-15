package api.dnevnik.partners.model.mark;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.work.Subject;
import api.dnevnik.partners.model.work.Work;
import api.dnevnik.partners.model.work.WorkType;
import lombok.Data;

import java.util.List;

@Data
public class FinalMarksResponse implements ApiHolder {

    private DnevnikPartnersApi api;

    private List<Mark> marks;

    private List<Work> works;

    private List<Subject> subjects;

    private List<WorkType> workTypes;

    @Override
    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(marks);
        api.injectMany(works);
        api.injectMany(subjects);
    }
}
