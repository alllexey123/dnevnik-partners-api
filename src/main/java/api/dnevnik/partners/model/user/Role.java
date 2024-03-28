package api.dnevnik.partners.model.user;

import com.google.gson.annotations.SerializedName;

public enum Role {

    @SerializedName("EduStudent")
    EDU_STUDENT,

    @SerializedName("UserAdministrator")
    USER_ADMINISTRATOR
}
