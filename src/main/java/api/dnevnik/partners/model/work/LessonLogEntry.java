package api.dnevnik.partners.model.work;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LessonLogEntry {

    private long person;

    @SerializedName("person_str")
    private String personStr;

    private long lesson;

    @SerializedName("lesson_str")
    private String lessonStr;

    private String comment;

    private String status;

    private LocalDateTime createdDate;

    public long getParsedPersonId() {
        return Long.parseLong(personStr);
    }

    public long getParsedLessonId() {
        return Long.parseLong(lessonStr);
    }
}
