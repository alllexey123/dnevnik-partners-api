package api.dnevnik.partners.model.mark;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class WeightedMarksResponse implements ApiHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private List<WeightedSubjectMarks> subjectMarks;

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(subjectMarks);
    }
}
