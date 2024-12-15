package api.dnevnik.partners.model.feed;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class UserFeedSummary implements ApiHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private List<ImportantWork> importantWorks;

    private List<UserFeedMarkCard> markCards;

    private String dayEmotion;

    private String feedMode;

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(importantWorks);
        api.injectMany(markCards);
    }
}
