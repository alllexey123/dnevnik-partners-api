package api.dnevnik.partners.model.mark;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.IdHolder;
import api.dnevnik.partners.model.user.Person;
import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.core.Single;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
public class Mark implements ApiHolder, IdHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private Long id;

    @SerializedName("id_str")
    private String idStr;

    private String type;

    private String value;

    private String textValue;

    private long person;

    @SerializedName("person_str")
    private String personStr;

    private long work;

    @SerializedName("work_str")
    private String workStr;

    private long lesson;

    private String lessonStr;

    private int number;

    private LocalDateTime date;

    private long workType;

    private Mood mood;

    private boolean use_avg_calc;

    public long getParsedId() {
        return Long.parseLong(idStr);
    }

    public long getParsedWorkId() {
        return Long.parseLong(workStr);
    }

    public long getParsedLessonId() {
        return Long.parseLong(lessonStr);
    }

    public Single<Person> getPersonById() {
        return api.getPersonById(person);
    }
}
