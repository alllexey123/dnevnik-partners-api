package api.dnevnik.partners.model.work;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
public class LessonLogEntry implements ApiHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

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
