package api.dnevnik.partners.network;

import lombok.Data;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import java.io.IOException;

@Data
public class AccessTokenInterceptor implements Interceptor {

    private AccessTokenProvider provider;

    @Override
    public Response intercept(Chain chain) throws IOException {
        String accessToken = provider.getAccessToken();
        if (accessToken == null) accessToken = "";
        return chain.proceed(chain.request().newBuilder().addHeader("Access-Token", accessToken).build());
    }

    public static void injectTokenProvider(OkHttpClient client, AccessTokenProvider provider) {
        client.interceptors().stream()
                .filter(interceptor -> interceptor instanceof AccessTokenInterceptor)
                .map(interceptor -> (AccessTokenInterceptor) interceptor)
                .forEach(interceptor -> interceptor.setProvider(provider));
    }

}
