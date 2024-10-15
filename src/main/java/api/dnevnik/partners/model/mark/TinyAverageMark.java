package api.dnevnik.partners.model.mark;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.user.Person;
import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.core.Single;
import lombok.Data;

import java.util.List;

@Data
public class TinyAverageMark implements ApiHolder {

    private DnevnikPartnersApi api;

    @SerializedName("person")
    private long personId;

    @SerializedName("person_str")
    private String personStr;

    @SerializedName("per-subject-averages")
    private List<SubjectAverage> subjectAverages;

    public Single<Person> getPerson() {
        return api.getPersonById(personId);
    }
}
