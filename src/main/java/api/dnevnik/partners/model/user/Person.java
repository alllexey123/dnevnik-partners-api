package api.dnevnik.partners.model.user;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.IdHolder;
import api.dnevnik.partners.model.mark.FinalMarksResponse;
import api.dnevnik.partners.model.mark.SubjectFinalMark;
import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.core.Single;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class Person implements ApiHolder, IdHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private long id;

    @SerializedName("id_str")
    private String idStr;

    // sometimes can be null
    private Long userId;

    @SerializedName("userId_str")
    private String userIdStr;

    private String firstName;

    private String lastName;

    private String middleName;

    private String shortName;

    private String sex;

    public Single<User> getUser() {
        return api.getUserById(userId);
    }

    public Single<List<EduGroup>> getEduGroups() {
        return api.getGroupsByPerson(id);
    }

    public Single<List<SubjectFinalMark>> getFinalMarksByGroup(long groupId) {
        return api.getFinalMarksByPerson(id, groupId);
    }

    public Single<FinalMarksResponse> getAllFinalMarksByGroup(long groupId) {
        return api.getAllFinalMarksByPerson(id, groupId);
    }
}
