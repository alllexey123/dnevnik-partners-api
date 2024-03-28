package api.dnevnik.partners.model.work;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Lesson {

    private long id;

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

    public long getParsedId() {
        return Long.parseLong(idStr);
    }
}
