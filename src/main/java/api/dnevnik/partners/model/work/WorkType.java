package api.dnevnik.partners.model.work;

import api.dnevnik.partners.model.IdHolder;
import lombok.Data;

@Data
public class WorkType implements IdHolder {

    private Long id;

    private Long schoolId;

    private Long kindId;

    private String kind;

    private String title;

    private String abbr;

    private Long weight;
}
