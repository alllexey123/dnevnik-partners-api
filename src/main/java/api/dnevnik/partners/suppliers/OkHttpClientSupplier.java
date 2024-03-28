package api.dnevnik.partners.suppliers;

import api.dnevnik.partners.network.AccessTokenInterceptor;
import okhttp3.OkHttpClient;

import java.util.function.Supplier;

public class OkHttpClientSupplier implements Supplier<OkHttpClient> {

    @Override
    public OkHttpClient get() {
        return new OkHttpClient.Builder()
                .addInterceptor(new AccessTokenInterceptor())
                .build();
    }
}
