package api.dnevnik.partners.model.mark;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SubjectAverage {

    private long subject;

    @SerializedName("subject_str")
    private String subjectStr;

    @SerializedName("avg-mark-value")
    private String average;
}
