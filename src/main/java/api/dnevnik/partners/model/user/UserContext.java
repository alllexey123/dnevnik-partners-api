package api.dnevnik.partners.model.user;

import lombok.Data;

import java.util.List;

@Data
public class UserContext {

    private long userId;

    private String avatarUrl;

    private List<Role> roles;

    private List<SchoolContext> schools;

    private List<EduGroup> eduGroups;

    private long personId;

    private String shortName;

    private List<Integer> schoolIds;

    private List<Long> groupIds;
}
