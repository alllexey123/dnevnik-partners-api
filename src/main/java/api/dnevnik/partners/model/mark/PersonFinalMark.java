package api.dnevnik.partners.model.mark;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.user.Person;
import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.core.Single;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class PersonFinalMark implements ApiHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    @SerializedName("person")
    private long personId;

    @SerializedName("person_str")
    private String personStr;

    @SerializedName("group")
    private long groupId;

    @SerializedName("group_str")
    private String groupStr;

    // nullable
    @SerializedName("reportingPeriod")
    private Long reportingPeriodId;

    @SerializedName("reportingPeriod_str")
    private String reportingPeriodStr;

    @SerializedName("per-subject-final-marks")
    private List<SubjectFinalMark> subjectFinalMarks;

    public long getParsedGroupId() {
        return Long.parseLong(groupStr);
    }

    @Override
    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(subjectFinalMarks);
    }

    public Single<Person> getPerson() {
        return api.getPersonById(personId);
    }
}
