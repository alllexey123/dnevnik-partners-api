package api.dnevnik.partners.model.mark;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SubjectFinalMark implements ApiHolder {

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
