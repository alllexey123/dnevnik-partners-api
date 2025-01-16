package api.dnevnik.partners.model.user;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.IdHolder;
import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.core.Single;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
public class ReportingPeriod implements ApiHolder, IdHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private long id;

    @SerializedName("id_str")
    private String idStr;

    private LocalDateTime start;

    private LocalDateTime finish;

    private int number;

    private String type;

    private String name;

    private int year;

    public long getParsedId() {
        return Long.parseLong(idStr);
    }


    public Single<String> getAverageMark(long person) {
        return api.getAverageMarksByPeriod(person, getParsedId());
    }

}
