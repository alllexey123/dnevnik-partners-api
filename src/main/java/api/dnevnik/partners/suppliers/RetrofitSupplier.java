package api.dnevnik.partners.suppliers;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.function.Supplier;

public class RetrofitSupplier implements Supplier<Retrofit> {

    private final Gson gson;

    private final OkHttpClient client;

    public RetrofitSupplier(Gson gson, OkHttpClient client) {
        this.gson = gson;
        this.client = client;
    }

    @Override
    public Retrofit get() {
        return new Retrofit.Builder()
                .baseUrl("https://api.dnevnik.ru/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }
}
