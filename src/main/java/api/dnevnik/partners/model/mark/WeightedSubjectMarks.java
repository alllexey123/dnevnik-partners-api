package api.dnevnik.partners.model.mark;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class WeightedSubjectMarks implements ApiHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private long subject;

    @SerializedName("subject_str")
    private String subjectStr;

    private List<WeightedMark> marks;

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(marks);
    }
}
