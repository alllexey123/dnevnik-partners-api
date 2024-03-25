package me.alllexey123.model.user;

import com.google.gson.annotations.SerializedName;

public enum Role {

    @SerializedName("EduStudent")
    EDU_STUDENT,

    @SerializedName("UserAdministrator")
    USER_ADMINISTRATOR
}
