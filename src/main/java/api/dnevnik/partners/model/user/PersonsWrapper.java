package api.dnevnik.partners.model.user;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class PersonsWrapper implements ApiHolder {

    private DnevnikPartnersApi api;

    private long id;

    @SerializedName("id_str")
    private String idStr;

    private List<Person> students;

    @Override
    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(students);
    }

    public long getParsedId() {
        return Long.parseLong(idStr);
    }
}
