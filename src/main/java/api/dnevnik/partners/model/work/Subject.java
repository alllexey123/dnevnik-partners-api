package api.dnevnik.partners.model.work;

import lombok.Data;

@Data
public class Subject {

    private long id;

    private String idStr;

    private String name;

    private String knowledgeArea;

    private Long fgosSubjectId;

    private Long espSubjectName;
}
