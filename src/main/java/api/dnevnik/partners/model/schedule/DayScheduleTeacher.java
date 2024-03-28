package api.dnevnik.partners.model.schedule;

import api.dnevnik.partners.model.user.Person;
import lombok.Data;

@Data
public class DayScheduleTeacher {

    private Person person;

    private String role;
}
