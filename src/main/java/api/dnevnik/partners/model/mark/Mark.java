package api.dnevnik.partners.model.mark;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Mark {

    private long id;

    @SerializedName("id_str")
    private String idStr;

    private String type;

    private String value;

    private String textValue;

    private long person;

    private String personStr;

    private long work;

    @SerializedName("work_str")
    private String workStr;

    private long lesson;

    private String lessonStr;

    private int number;

    private OffsetDateTime date;

    private long workType;

    private String mood;

    private boolean use_avg_calc;

    // preferred
    public long getParsedId() {
        return Long.parseLong(idStr);
    }

    public long getParsedWorkId() {
        return Long.parseLong(workStr);
    }

    public long getParsedLessonId() {
        return Long.parseLong(lessonStr);
    }
}
