package api.dnevnik.partners.model.user;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.IdHolder;
import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.core.Single;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class User implements ApiHolder, IdHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private Long id;

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

    private LocalDateTime birthday;

    private List<Role> roles;

    private String phone;

    public Single<Person> getPerson() {
        return api.getPersonById(personId);
    }
}
