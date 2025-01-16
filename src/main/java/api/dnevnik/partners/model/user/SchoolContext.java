package api.dnevnik.partners.model.user;

import api.dnevnik.partners.model.IdHolder;
import lombok.Data;

import java.util.List;

@Data
public class SchoolContext implements IdHolder {

    private Long id;

    private String name;

    private String type;

    private List<Long> groupIds;
}
