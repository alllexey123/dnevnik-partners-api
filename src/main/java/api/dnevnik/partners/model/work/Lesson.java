package api.dnevnik.partners.model.work;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.IdHolder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Lesson implements ApiHolder, IdHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private Long id;

    @SerializedName("id_str")
    private String idStr;

    private String title;

    private LocalDateTime date;

    private int number;

    private Subject subject;

    private long group;

    private List<Work> works;

    private List<Long> teachers;

    private List<String> teachersStr;

    private String status;

    public long getParsedId() {
        return Long.parseLong(idStr);
    }

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(works);
        api.inject(subject);
    }
}
