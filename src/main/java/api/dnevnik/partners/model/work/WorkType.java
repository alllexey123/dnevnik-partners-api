package api.dnevnik.partners.model.work;

import lombok.Data;

@Data
public class WorkType {

    private long id;

    private long schoolId;

    private Long kindId;

    private String kind;

    private String title;

    private String abbr;

    private Long weight;
}
