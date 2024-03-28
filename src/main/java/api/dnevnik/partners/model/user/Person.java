package api.dnevnik.partners.model.user;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Person {

    private long id;

    @SerializedName("id_str")
    private String idStr;

    private long userId;

    @SerializedName("userId_str")
    private String userIdStr;

    private String firstName;

    private String lastName;

    private String middleName;

    private String shortName;

    private String sex;
}
