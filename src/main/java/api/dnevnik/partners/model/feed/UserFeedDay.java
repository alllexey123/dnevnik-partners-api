package api.dnevnik.partners.model.feed;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserFeedDay implements ApiHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private LocalDateTime date;

    private LocalDateTime nextWorkingDayDate;

    private UserFeedSummary summary;

    private List<UserFeedHomework> todayHomeworks;

    private List<UserFeedLesson> todaySchedule;

    private List<UserFeedHomework> nextDayHomeworks;

    private List<UserFeedLesson> nextDaySchedule;

    private List<UserFeedLogEntry> logEntries;

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.inject(summary);
        api.injectMany(todayHomeworks);
        api.injectMany(todaySchedule);
        api.injectMany(nextDayHomeworks);
        api.injectMany(nextDaySchedule);
        api.injectMany(logEntries);
    }
}
