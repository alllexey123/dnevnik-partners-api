package api.dnevnik.partners;

import api.dnevnik.partners.data.DnevnikClientRepository;
import api.dnevnik.partners.data.RuntimeRepository;
import api.dnevnik.partners.model.user.UserContext;
import api.dnevnik.partners.network.AccessTokenInterceptor;
import api.dnevnik.partners.network.AccessTokenProvider;
import api.dnevnik.partners.suppliers.*;
import com.google.gson.Gson;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import lombok.*;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


@Data
public class DnevnikClient implements AccessTokenProvider {

    private DnevnikPartnersApi api;

    private DnevnikClientRepository repository;

    private BehaviorSubject<UserContext> lastContextResponse = BehaviorSubject.create();

    protected DnevnikClient() {
    }

    public static DnevnikClient create() {
        Gson gson = new GsonSupplier().get();
        OkHttpClient okHttpClient = new OkHttpClientSupplier().get();
        Retrofit retrofit = new RetrofitSupplier(gson, okHttpClient).get();
        DnevnikPartnersApi api = new DnevnikPartnersApiSupplier(retrofit).get();
        RuntimeRepository repository = new RuntimeRepository();
        DnevnikClient dnevnikClient = new DnevnikClient();
        dnevnikClient.setApi(api);
        dnevnikClient.setRepository(repository);
        AccessTokenInterceptor.injectTokenProvider(okHttpClient, dnevnikClient);
        return dnevnikClient;
    }

    public Single<UserContext> updateUserContext() {
        return this.api.getContext().doOnSuccess(lastContextResponse::onNext);
    }

    @Override
    public String getAccessToken() {
        return this.repository.getAccessToken();
    }

    public void setAccessToken(String accessToken) {
        this.repository.setAccessToken(accessToken);
    }

    public Single<UserContext> getUserContext() {
        if (this.lastContextResponse.hasValue()) return Single.just(this.lastContextResponse.getValue());
        return updateUserContext();
    }

    public Single<Long> getPersonId() {
        return getUserContext().map(UserContext::getPersonId);
    }

    public Single<Long> getUserId() {
        return getUserContext().map(UserContext::getUserId);
    }
}
