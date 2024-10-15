package api.dnevnik.partners.model.work;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import lombok.Data;

@Data
public class Subject implements ApiHolder {

    private DnevnikPartnersApi api;

    private long id;

    private String idStr;

    private String name;

    private String knowledgeArea;

    private Long fgosSubjectId;

    private Long espSubjectName;
}
