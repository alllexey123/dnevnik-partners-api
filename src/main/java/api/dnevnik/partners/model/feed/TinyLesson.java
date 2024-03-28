package api.dnevnik.partners.model.feed;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TinyLesson {

    private long id;

    private LocalDateTime date;
}
