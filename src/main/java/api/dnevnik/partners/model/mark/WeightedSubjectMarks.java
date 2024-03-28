package api.dnevnik.partners.model.mark;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class WeightedSubjectMarks {

    private long subject;

    @SerializedName("subject_str")
    private String subjectStr;

    private List<WeightedMark> marks;
}
