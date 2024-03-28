package api.dnevnik.partners.model.user;

import lombok.Data;

@Data
public class UserRelative {

    private String type;

    private Person person;
}
