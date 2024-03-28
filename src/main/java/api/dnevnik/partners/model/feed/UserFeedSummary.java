package api.dnevnik.partners.model.feed;

import lombok.Data;

import java.util.List;

@Data
public class UserFeedSummary {

    private List<ImportantWork> importantWorks;

    private List<UserFeedMarkCard> markCards;

    private String dayEmotion;

    private String feedMode;
}
