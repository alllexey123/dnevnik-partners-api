package api.dnevnik.partners.model.work;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Work implements ApiHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private long id;

    @SerializedName("id_str")
    private String idStr;

    private String type;

    private long workType;

    private String markType;

    private int markCount;

    private long lesson;

    @SerializedName("lesson_str")
    private String lessonStr;

    private boolean displayInJournal;

    private String status;

    private long eduGroup;

    @SerializedName("eduGroup_str")
    private String eduGroupStr;

    private List<Task> tasks;

    private String text;

    private int periodNumber;

    private String periodType;

    private long subjectId;

    private boolean isImportant;

    private LocalDateTime targetDate;

    private LocalDateTime sentDate;

    private long createdBy;

    public long getParsedId() {
        return Long.parseLong(idStr);
    }

    public long getParsedLessonId() {
        return Long.parseLong(lessonStr);
    }

    public long getParsedEduGroupId() {
        return Long.parseLong(eduGroupStr);
    }

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(tasks);
    }
}
