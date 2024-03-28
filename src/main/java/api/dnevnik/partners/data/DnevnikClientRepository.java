package api.dnevnik.partners.data;

public interface DnevnikClientRepository {

    void setAccessToken(String accessToken);

    String getAccessToken();

}
