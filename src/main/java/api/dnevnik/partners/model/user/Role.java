package api.dnevnik.partners.model.user;

import com.google.gson.annotations.SerializedName;

public enum Role {

    @SerializedName("EduStudent")
    EDU_STUDENT,

    @SerializedName("EduStaff")
    EDU_STAFF,

    @SerializedName("EduParent")
    EDU_PARENT,

    @SerializedName("OrganizationStaff")
    ORGANIZATION_STAFF,

    @SerializedName("EduSchoolAdministrator")
    EDU_SCHOOL_ADMINISTRATOR,
}
