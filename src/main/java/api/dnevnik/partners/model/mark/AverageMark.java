package api.dnevnik.partners.model.mark;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AverageMark extends TinyAverageMark {

    private long group;

    @SerializedName("group_str")
    private String groupStr;

    private long reportingPeriod;

    @SerializedName("reportingPeriod_str")
    private String reportingPeriodStr;

    public long getParsedGroupId() {
        return Long.parseLong(groupStr);
    }

    public long getParsedReportingPeriodId() {
        return Long.parseLong(reportingPeriodStr);
    }

}
