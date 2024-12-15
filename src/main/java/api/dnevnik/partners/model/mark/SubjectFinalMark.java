package api.dnevnik.partners.model.mark;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class SubjectFinalMark implements ApiHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private long subject;

    @SerializedName("subject_str")
    private String subjectStr;

    @SerializedName("final-mark")
    private Mark finalMark;

    @Override
    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.inject(finalMark);
    }
}
