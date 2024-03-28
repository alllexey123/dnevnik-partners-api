package api.dnevnik.partners.suppliers;

import api.dnevnik.partners.DnevnikPartnersApi;
import retrofit2.Retrofit;

import java.util.function.Supplier;

public class DnevnikPartnersApiSupplier implements Supplier<DnevnikPartnersApi> {

    private final Retrofit retrofit;

    public DnevnikPartnersApiSupplier(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public DnevnikPartnersApi get() {
        return retrofit.create(DnevnikPartnersApi.class);
    }
}
