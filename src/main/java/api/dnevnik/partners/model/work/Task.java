package api.dnevnik.partners.model.work;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task implements ApiHolder {

    private DnevnikPartnersApi api;

    private long id;

    @SerializedName("id_str")
    private String idStr;

    private long person;

    @SerializedName("person_str")
    private String personStr;

    private long work;

    @SerializedName("work_str")
    private String workStr;

    private String status;

    private LocalDateTime targetDate;

    public long getParsedId() {
        return Long.parseLong(idStr);
    }

    public long getParsedWorkId() {
        return Long.parseLong(workStr);
    }



}
