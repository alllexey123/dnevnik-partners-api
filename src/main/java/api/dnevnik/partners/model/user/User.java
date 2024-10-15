package api.dnevnik.partners.model.user;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.core.Single;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class User implements ApiHolder {

    private DnevnikPartnersApi api;

    private long id;

    @SerializedName("id_str")
    private String idStr;

    private long personId;

    @SerializedName("personId_str")
    private String personIdStr;

    private String name;

    private String email;

    private String login;

    private String fullName;

    private String middleName;

    private String lastName;

    private String shortName;

    private String locale;

    private String timezone;

    private String sex;

    private String photoSmall;

    private String photoMedium;

    private String photoLarge;

    private OffsetDateTime birthday;

    private List<Role> roles;

    private String phone;

    public Single<Person> getPerson() {
        return api.getPersonById(personId);
    }
}
