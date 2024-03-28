package api.dnevnik.partners.model.feed;

import api.dnevnik.partners.model.work.Work;
import lombok.Data;

@Data
public class ImportantWork {

    private Work work;

    private String subjectName;

    private String workTypeName;

}
