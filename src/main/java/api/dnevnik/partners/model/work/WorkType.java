package api.dnevnik.partners.model.work;

import lombok.Data;

@Data
public class WorkType {

    private long id;

    private int schoolId;

    private String abbreviation;

    private String name;

    private boolean isFinal;

    private boolean isImportant;

    private int kindId;

    private String kind;
}
