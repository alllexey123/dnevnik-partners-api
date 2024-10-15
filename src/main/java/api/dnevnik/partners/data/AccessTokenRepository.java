package api.dnevnik.partners.data;

public interface AccessTokenRepository {

    void setAccessToken(String accessToken);

    String getAccessToken();

}
