package api.dnevnik.partners.model.user;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReportingPeriod {

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
}
