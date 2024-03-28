package api.dnevnik.partners.model.mark;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class TinyAverageMark {

    private long person;

    @SerializedName("person_str")
    private String personStr;

    @SerializedName("per-subject-averages")
    private List<SubjectAverage> subjectAverages;
}
