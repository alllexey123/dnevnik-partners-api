package api.dnevnik.partners.model.feed;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class ImportantWorkType implements ApiHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private long id;

    private String name;
}
