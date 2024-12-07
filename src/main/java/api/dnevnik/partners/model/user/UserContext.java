package api.dnevnik.partners.model.user;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import io.reactivex.rxjava3.core.Single;
import lombok.Data;

import java.util.List;

@Data
public class UserContext implements ApiHolder {

    private DnevnikPartnersApi api;

    private long userId;

    private String avatarUrl;

    private List<Role> roles;

    private List<SchoolContext> schools;

    private List<EduGroup> eduGroups;

    private long personId;

    private String shortName;

    private List<Long> schoolIds;

    private List<Long> groupIds;

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(eduGroups);
    }

    /**
     * Also returns subgroups, unlike {@link UserContext#groupIds}
     * @return all groups with this person
     */
    public Single<List<EduGroup>> getAllEduGroups() {
        return api.getGroupsByPerson(personId);
    }
}
