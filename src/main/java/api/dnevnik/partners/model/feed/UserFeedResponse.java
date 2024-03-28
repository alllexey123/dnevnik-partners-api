package api.dnevnik.partners.model.feed;

import lombok.Data;

import java.util.List;

@Data
public class UserFeedResponse {

    private List<UserFeedDay> days;
}
