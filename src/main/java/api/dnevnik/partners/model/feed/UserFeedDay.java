package api.dnevnik.partners.model.feed;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserFeedDay {

    private LocalDateTime date;

    private LocalDateTime nextWorkingDayDate;

    private UserFeedSummary summary;

    private List<UserFeedHomework> todayHomeworks;

    private List<UserFeedLesson> todaySchedule;

    private List<UserFeedHomework> nextDayHomeworks;

    private List<UserFeedLesson> nextDaySchedule;

    private List<UserFeedLogEntry> logEntries;
}
