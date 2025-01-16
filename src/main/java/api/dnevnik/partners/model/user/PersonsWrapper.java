package api.dnevnik.partners.model.user;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.IdHolder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class PersonsWrapper implements ApiHolder, IdHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private Long id;

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
