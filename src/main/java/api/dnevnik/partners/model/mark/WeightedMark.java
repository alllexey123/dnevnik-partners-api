package api.dnevnik.partners.model.mark;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import lombok.Data;

@Data
public class WeightedMark implements ApiHolder {

    private DnevnikPartnersApi api;

    private long person;

    private float value;
}
