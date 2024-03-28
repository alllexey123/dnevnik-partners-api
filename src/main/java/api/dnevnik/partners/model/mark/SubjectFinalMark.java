package api.dnevnik.partners.model.mark;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SubjectFinalMark {

    private long subject;

    @SerializedName("subject_str")
    private String subjectStr;

    @SerializedName("final-mark")
    private Mark finalMark;


}
