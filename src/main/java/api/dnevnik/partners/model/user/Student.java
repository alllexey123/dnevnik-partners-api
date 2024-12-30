package api.dnevnik.partners.model.user;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class Student implements ApiHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private Person person;

    @SerializedName("membershipstatus")
    private MembershipStatus membershipStatus;

    @Override
    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.inject(person);
    }
}
