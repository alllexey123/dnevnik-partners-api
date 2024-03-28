package api.dnevnik.partners.model.user;

import lombok.Data;

import java.util.List;

@Data
public class SchoolContext {

    private int id;

    private String name;

    private String type;

    private List<Long> groupIds;
}
