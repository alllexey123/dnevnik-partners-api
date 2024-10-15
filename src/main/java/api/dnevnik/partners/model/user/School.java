package api.dnevnik.partners.model.user;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class School implements ApiHolder {

    private DnevnikPartnersApi api;

    private String fullName;

    private String avatarSmall;

    private String city;

    private String municipality;

    private int regionId;

    private String markType;

    private int timeZone;

    @SerializedName("uses_avg")
    private boolean usesAvg;

    @SerializedName("uses_weighted_avg")
    private boolean usesWeightedAvg;

    private long id;

    @SerializedName("id_str")
    private String idStr;

    private String name;

    private String educationType;

    private String tsoRegionTreePath;
}
