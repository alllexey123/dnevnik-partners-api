package api.dnevnik.partners.model.mark;

import api.dnevnik.partners.model.work.Subject;
import api.dnevnik.partners.model.work.Work;
import api.dnevnik.partners.model.work.WorkType;
import lombok.Data;

import java.util.List;

@Data
public class FinalMarksResponse {

    private List<Mark> marks;

    private List<Work> works;

    private List<Subject> subjects;

    private List<WorkType> workTypes;
}
