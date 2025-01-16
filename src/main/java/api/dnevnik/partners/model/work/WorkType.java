package api.dnevnik.partners.model.work;

import api.dnevnik.partners.model.IdHolder;
import lombok.Data;

@Data
public class WorkType implements IdHolder {

    private long id;

    private long schoolId;

    private Long kindId;

    private String kind;

    private String title;

    private String abbr;

    private Long weight;
}
