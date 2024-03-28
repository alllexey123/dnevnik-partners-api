package api.dnevnik.partners.model.mark;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class PersonFinalMark {

    private long person;

    @SerializedName("person_str")
    private String personStr;

    private long group;

    @SerializedName("group_str")
    private String groupStr;

    // nullable
    private Long reportingPeriod;

    @SerializedName("reportingPeriod_str")
    private String reportingPeriodStr;

    @SerializedName("per-subject-final-marks")
    private List<SubjectFinalMark> subjectFinalMarks;

    public long getParsedGroupId() {
        return Long.parseLong(groupStr);
    }
}
