package api.dnevnik.partners.model.user;

import api.dnevnik.partners.model.work.Subject;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class EduGroup {

    private long id;

    @SerializedName("id_str")
    private String idStr;

    private List<Long> parentIds;

    @SerializedName("parentIds_str")
    private List<String> parentIdsStr;

    private String type;

    private String name;

    private String fullName;

    private int parallel;

    private long timetable;

    @SerializedName("timetable_str")
    private String timetableStr;

    private String status;

    @SerializedName("studyyear")
    private int studyYear;

    private List<Subject> subjects;

    private String journalType;

    // preferred
    public long getParsedId() {
        return Long.parseLong(idStr);
    }
}
