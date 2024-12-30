package api.dnevnik.partners.model.user;

import com.google.gson.annotations.SerializedName;

public enum MembershipStatus {
    @SerializedName("Active") ACTIVE,
    @SerializedName("Archive") ARCHIVE,
}
