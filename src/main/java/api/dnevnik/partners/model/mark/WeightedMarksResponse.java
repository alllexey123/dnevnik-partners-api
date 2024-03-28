package api.dnevnik.partners.model.mark;

import lombok.Data;

import java.util.List;

@Data
public class WeightedMarksResponse {

    private List<WeightedSubjectMarks> subjectMarks;
}
