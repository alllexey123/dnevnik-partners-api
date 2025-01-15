package api.dnevnik.partners.model.mark;

import com.google.gson.annotations.SerializedName;

public enum Mood {
    @SerializedName("Good") GOOD,
    @SerializedName("Average") AVERAGE,
    @SerializedName("Bad") BAD,
    @SerializedName("NotSet") NOT_SET,
}
